package upd.cardservice.Services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import okhttp3.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;
import upd.cardservice.Models.Card;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardApiService {

    private final CommandGateway commandGateway;
    private final String baseUrl = "https://api.scryfall.com";

    private final OkHttpClient httpClient = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public CardApiService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public List<String> autocompleteCall(String partialCardname) {
        String url = baseUrl+"/cards/autocomplete?q="+partialCardname;
        String response = sendGet(url);
        if(response==null)
            return null;

        try {
            JsonNode jsonObj = mapper.readTree(response);
            System.out.println(jsonObj.get("data"));
            ArrayList<String> data= mapper.convertValue(jsonObj.get("data"),ArrayList.class);
            if(data!=null) {
                return data;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        return new ArrayList<>();
    }

    public List<Card> getCardsBySet(String set) {
        return null;
    }

    public Card findCard(String cardName) {
      String url = baseUrl+"/cards/named?exact="+cardName;
      String response = sendGet(url);
      if(response==null) {
          return new Card();
      }
      List<Card> card = convertToCard(response);
      if(card==null||card.size()==0) {
          return new Card();
      }
      return card.get(0);
    }

    public List<Card> getCardsByName(List<String> cardNames) {
        List<Card> cards = new ArrayList<>();
        System.out.println(cardNames);
        if(cardNames.size()>74) {
            List<List<String>> smallerList = new ArrayList<>();
            int times = (int) Math.ceil((double) cardNames.size()/70);
            for (int i = 0; i<times;i++) {
                List<String> smallList = cardNames.subList(i, i + 70);
                smallerList.add(smallList);
            }
            for(List<String> cardList : smallerList) {
                cards.addAll(getCardsByName(cardList));
            }
            return cards;
        }

        String url = baseUrl+"/cards/collection";

        String response= sendGet(url,cardNames);

        cards = convertToCards(response);

        if(cards==null) {
            return new ArrayList<>();
        }

        return cards;
    }

    private String sendGet(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        System.out.println(request);

        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println(response);
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String sendGet(String url, List<String> identifiers) {

        JsonNode rootNode = mapper.createObjectNode();

        ArrayNode identifiersNode = mapper.createArrayNode();

        for(String id : identifiers) {
            JsonNode idNode = mapper.createObjectNode();
            ((ObjectNode) idNode).put("name",id);
            System.out.println(idNode);
            identifiersNode.add(idNode);
        }


        ((ObjectNode) rootNode).set("identifiers",identifiersNode);

        RequestBody body = RequestBody.create(rootNode.toString(),JSON);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try( Response response = httpClient.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    private List<Card> convertToCard(String json) {
        Card card = new Card();
        try {
            JsonNode jsonObj = mapper.readTree(json);
            if(!(jsonObj.get("object").asText()).equals("card")) {
                if(jsonObj.get("object").asText().equals("list")) {
                   return convertToCards(json);
                } else {
                    return null;
                }

            }
            card.setCardname(mapper.convertValue(jsonObj.get("name"),String.class));
            card.setCmc(mapper.convertValue(jsonObj.get("cmc"),int.class));
            card.setColors(mapper.convertValue(jsonObj.get("color_identity"),ArrayList.class));
            card.setType(mapper.convertValue(jsonObj.get("type_line"),String.class));
            card.setSetName(mapper.convertValue(jsonObj.get("set_name"),String.class));
            card.setSetId(mapper.convertValue(jsonObj.get("set"),String.class));
            card.setText(mapper.convertValue(jsonObj.get("oracle_text"),String.class));
            card.setManaCost(mapper.convertValue(jsonObj.get("mana_cost"),String.class));

            JsonNode artNode = jsonObj.get("image_uris");

            card.setImageUrl(mapper.convertValue(artNode.get("normal"),String.class));
            card.setArtUrl(mapper.convertValue(artNode.get("art_crop"),String.class));

            List<Card> cardList = new ArrayList<>();
           cardList.add(card);
           return cardList;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Card> convertToCards(String json) {
        List<Card> cardList = new ArrayList<>();
        try {
            JsonNode jsonObj = mapper.readTree(json);
            if (!(jsonObj.get("object").asText()).equals("list")) {
                if (jsonObj.get("object").asText().equals("card")) {
                   return convertToCard(json);
                } else {
                    return null;
                }
            }
            JsonNode cards = jsonObj.get("data");
            cards.elements().forEachRemaining(data -> {
                List<Card> tempList = convertToCard(data.toString());
                if(tempList!=null&&tempList.size()!=0)
                cardList.add(tempList.get(0));
            }) ;
            return cardList;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
 }
