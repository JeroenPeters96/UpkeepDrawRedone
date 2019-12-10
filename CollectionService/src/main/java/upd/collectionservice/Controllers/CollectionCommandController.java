package upd.collectionservice.Controllers;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upd.collectionservice.Commands.AddCardsToCollection;
import upd.collectionservice.Commands.RemoveCardsFromCollection;
import upd.collectionservice.Models.CardCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cmd")
public class CollectionCommandController {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Autowired
    public CollectionCommandController(final CommandGateway commandGateway, final QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/add/{accId}/{cardId}/{amount}")
    public ResponseEntity<String> addCardsToCollection(@PathVariable String accId,
                                                       @PathVariable String cardId,
                                                       @PathVariable int amount) {
        String id = UUID.randomUUID().toString();
        System.out.println(cardId);
        CardCollection card = new CardCollection();
        card.setAccountId(accId);
        card.setCardId(cardId);
        card.setCount(amount);

        List<CardCollection> cardList = new ArrayList<>();
        cardList.add(card);

        commandGateway.send(
                new AddCardsToCollection(
                        id,
                        accId,
                        cardList
                )
        );
        return new ResponseEntity<>(createMessage("Card added to collection"), HttpStatus.OK);
    }

    @PostMapping("/remove/{accId}/{cardId}/{amount}")
    public ResponseEntity<String> removeCardsFromCollection(@PathVariable String accId,
                                                       @PathVariable String cardId,
                                                       @PathVariable int amount) {
        String id = UUID.randomUUID().toString();
        CardCollection card = new CardCollection();
        card.setAccountId(accId);
        card.setCardId(cardId);
        card.setCount(amount);

        List<CardCollection> cardList = new ArrayList<>();
        cardList.add(card);

        commandGateway.send(
                new RemoveCardsFromCollection(
                        id,
                        cardList
                )
        );
        return new ResponseEntity<>(createMessage("Card removed from collection"), HttpStatus.OK);
    }

//    @PostMapping("/trade/{sendId}/{receiveId}/{cardId}/{amount}")
//    public ResponseEntity<String> trade(@PathVariable String sendId, @PathVariable String receiveId, @PathVariable String cardId, @PathVariable int amount) {
//        String id = UUID.randomUUID().toString();
//        CardCollection card = new CardCollection();
//        card.setCardId(cardId);
//        card.setCount(amount);
//    }
//

    private String createMessage(String message) {
        return "{ \"message\":\""+message+"\"}";
    }

    private String createMessage(String json,String message) {
        return "{ \""+json+"\":\""+message+"\"}";
    }
}
