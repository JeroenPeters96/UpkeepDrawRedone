package upd.cardservice.Services;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.cardservice.Models.Card;
import upd.cardservice.Queries.GetAutocomplete;
import upd.cardservice.Queries.GetCardByName;
import upd.cardservice.Queries.GetCardsById;
import upd.cardservice.Queries.GetCardsBySet;
import upd.cardservice.Repo.CardCrudRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardQueryHandler {

    private CardCrudRepository repository;
    private CardApiService apiService;


    @Autowired
    public CardQueryHandler(CardCrudRepository repository, CardApiService apiService) {
        this.repository = repository;
        this.apiService = apiService;
    }

    public CardQueryHandler() {
    }

    @QueryHandler
    public Card handle(GetCardByName query) {
       Card card = repository.findCardByCardname(query.getCardName());
       if(card==null) {
           card = apiService.findCard(query.getCardName());
           repository.save(card);
       }
       return card;
    }

    @QueryHandler
    public List<Card> handle(GetCardsById query) {
        List<Card> cardList = new ArrayList<>();
        for(String cardId : query.getCardIdList()) {
            cardList.add(repository.findCardById(cardId));
        }
        return cardList;
    }

    @QueryHandler
    public List<String> handle(GetAutocomplete query) {
        return apiService.autocompleteCall(query.getPartialCardname());
    }

    @QueryHandler
    public List<Card> handle(GetCardsBySet query) {
        return apiService.getCardsBySet(query.getSet());
    }

}
