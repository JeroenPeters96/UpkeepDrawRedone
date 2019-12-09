package upd.collectionservice.Services;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.collectionservice.Events.CardsAddedToCollection;
import upd.collectionservice.Events.CardsRemovedCardsFromCollection;
import upd.collectionservice.Events.CardsTraded;
import upd.collectionservice.Models.CardCollection;
import upd.collectionservice.Repo.CollectionCrudRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionEventHandler {

    private final CollectionCrudRepo repo;

    @Autowired
    public CollectionEventHandler(final CollectionCrudRepo repo) {
        this.repo = repo;
    }

    @EventHandler
    public void on(CardsAddedToCollection event) {
        addCards(event.getCards());
    }

    @EventHandler
    public void on(CardsRemovedCardsFromCollection event) {
        removeCards(event.getCards());
    }

    @EventHandler
    public void on(CardsTraded event) {
        List<CardCollection> cardsToRemove = new ArrayList<>(event.getCards());
        List<CardCollection> cardsToAdd = new ArrayList<>(event.getCards());

        for(int count = 0; event.getCards().size() > count; count++) {
           CardCollection tempReceive = cardsToAdd.get(count);
           tempReceive.setAccountId(event.getReceiveAccountId());
           CardCollection tempSend = cardsToRemove.get(count);
           tempSend.setAccountId(event.getSendAccountId());
        }

        addCards(cardsToAdd);
        removeCards(cardsToRemove);
    }



    private void addCards(List<CardCollection> cards) {
        for(int count = 0; cards.size() > count; count++) {
            addCard(cards.get(count));
        }
    }

    private void addCard(CardCollection card) {
        CardCollection selectedCard = repo.findCardCollectionByAccountIdAndCardId(card.getAccountId(),card.getCardId());
        if(selectedCard != null) {
            selectedCard.setCount(selectedCard.getCount()+card.getCount());
            repo.save(selectedCard);
        } else {
            repo.save(card);
        }
    }

    private void removeCards(List<CardCollection> cards) {
        for(int count = 0; cards.size() > count; count++) {
            removeCard(cards.get(count));
        }
    }

    private void removeCard(CardCollection card) {
        CardCollection selectedCard = repo.findCardCollectionByAccountIdAndCardId(card.getAccountId(),card.getCardId());
        if(selectedCard != null) {
            selectedCard.setCount(selectedCard.getCount()-card.getCount());
            if(selectedCard.getCount()<=0) {
                repo.deleteByAccountIdAndCardId(selectedCard.getAccountId(),selectedCard.getCardId());
            }
        }
    }

}
