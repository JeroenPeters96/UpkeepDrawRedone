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
        if (card == null) {
            card = apiService.findCard(query.getCardName());
            System.out.println(card);
            if (card == null) {
                return new Card();
            }
            repository.save(card);
        }
        return card;
    }

    @QueryHandler
    public List<Card> handle(GetCardsById query) {
        List<Card> cardList = new ArrayList<>();
        for (Integer cardId : query.getCardIdList()) {
            if (repository.findById(cardId).isPresent())
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
        List<String> cardNames = query.getCardNames();
        List<String> rest = new ArrayList<>(cardNames);
        List<Card> cards = new ArrayList<>();
        System.out.println(cardNames);
        for (String cardName : cardNames) {
            if (repository.findCardByCardname(cardName) != null) {
                System.out.println("found "+cardName);
                cards.add(repository.findCardByCardname(cardName));
                rest.remove(cardName);
            }
        }
        if (rest.size() != 0) {
            List<Card> newCards = apiService.getCardsByName(rest);
            if (newCards != null) {
                for (Card newCard : newCards) {
                    repository.save(newCard);
                    cards.add(newCard);
                }
            }
        }
        return cards;
    }

    @QueryHandler
    public List<Card> handle(GetCardsLikeName query) {
        List<String> cardNames = apiService.autocompleteCall(query.getCardName());
        if (cardNames != null && cardNames.size() > 0) {
            List<Card> cards = new ArrayList<>();
            for (String cardName : cardNames) {
                Card card = repository.findCardByCardname(cardName);
                //cards.add(card);
                if (card == null) {
                    card = apiService.findCard(cardName);
                    if (card != null) {
                        repository.save(card);
                        cards.add(card);
                    }
                } else {
                    cards.add(card);
                }
            }
            return cards;
        }
        return new ArrayList<>();
    }

}
