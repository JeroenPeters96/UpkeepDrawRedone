package upd.cardservice.Services;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import upd.cardservice.Models.Card;
import upd.cardservice.Queries.*;
import upd.cardservice.Repo.CardCrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
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
           System.out.println(card);
           if(card==null) {
               return new Card();
           }
           repository.save(card);
       }
       return card;
    }

    @QueryHandler
    public List<Card> handle(GetCardsById query) {
        List<Card> cardList = new ArrayList<>();
        for(Integer cardId : query.getCardIdList()) {
            if(repository.findById(cardId).isPresent())
            cardList.add(repository.findById(cardId).get());
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

    @QueryHandler
    public List<Card> handle(GetCardsByName query) {
        return apiService.getCardsByName(query.getCardNames());
    }

}
