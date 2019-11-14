package upd.cardservice.Services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
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
      Card card = new Card();
        try {
            JsonNode jsonObj = mapper.readTree(response);
            System.out.println(jsonObj);
            if(!(jsonObj.get("object").asText()).equals("card")) {
                return card;
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

            System.out.println(card);
            return card;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new Card();
        }
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

    public List<Card> getCardsByName(List<String> cardNames) {
        List<Card> cards = new ArrayList<>();
        for(String cardname : cardNames) {
            cards.add(findCard(cardname));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return cards;
    }
}
