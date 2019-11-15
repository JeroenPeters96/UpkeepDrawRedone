package upd.deckservice.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upd.deckservice.Commands.*;
import upd.deckservice.Controllers.IncomingModels.*;
import upd.deckservice.Models.Deck;
import upd.deckservice.Queries.FindDeckById;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/cmd")
@Api(value = "/cmd",tags = {"Account Commands"})
@SwaggerDefinition( tags = {
        @Tag(name = "Deck Commands",description = "Deck related functionalities")
})
@SuppressWarnings("Duplicates")
public class DeckCommandController {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Autowired
    public DeckCommandController(final CommandGateway commandGateway, @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") final QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDeck(@RequestBody CreateDeckApiModel apiModel) {
        String id = UUID.randomUUID().toString();
        String deckId = UUID.randomUUID().toString();
        commandGateway.send(new CreateDeck(
                id,
                deckId,
                apiModel.getAccountId(),
                apiModel.getName(),
                apiModel.getDescription(),
                apiModel.getFormat()
        ));

        Deck savedDeck;

        try {
            savedDeck = queryGateway.query(new FindDeckById(deckId), Deck.class).get();
            if (savedDeck.getId().equals(deckId) &&
                    savedDeck.getAccountId().equals(apiModel.getAccountId()) &&
                    savedDeck.getDeckname().equals(apiModel.getName()) &&
                    savedDeck.getCards().isEmpty()) {
                return new ResponseEntity<>("Deck creation succesfull", HttpStatus.OK);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Deck creation unsuccesfull", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Deck creation unsuccesfull", HttpStatus.NOT_FOUND);
    }


    @PostMapping("/createCards")
    public ResponseEntity<String> createWithCards(@RequestBody CreateDeckWithCardsApiModel apiModel) {
        String id = UUID.randomUUID().toString();
        String deckId = UUID.randomUUID().toString();
        commandGateway.send(new CreateDeckWithCards(
                id,
                deckId,
                apiModel.getAccountId(),
                apiModel.getName(),
                apiModel.getDescription(),
                apiModel.getCards(),
                apiModel.getFormat(),
                apiModel.getFormat()
        ));
        Deck savedDeck;

        try {
            savedDeck = queryGateway.query(new FindDeckById(deckId), Deck.class).get();
            if (savedDeck.getId().equals(deckId) &&
                    savedDeck.getAccountId().equals(apiModel.getAccountId()) &&
                    savedDeck.getDeckname().equals(apiModel.getName()) &&
                    savedDeck.getCards().equals(apiModel.getCards())) {
                return new ResponseEntity<>("Deck creation succesfull", HttpStatus.OK);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Deck creation unsuccesfull", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Deck creation unsuccesfull", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addCardsToDeck(@RequestBody AddCardApiModel apiModel) {
        String id = UUID.randomUUID().toString();
        Deck savedDeck;

        try {
            savedDeck = queryGateway.query(new FindDeckById(apiModel.getDeckId()), Deck.class).get();
            if (savedDeck == null) {
                return new ResponseEntity<>("Adding cards was unsuccesfull", HttpStatus.BAD_REQUEST);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Adding cards was unsuccesfull", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        commandGateway.send(new AddCard(
                id,
                apiModel.getDeckId(),
                apiModel.getCards()
        ));

        Deck newSavedDeck;

        try {
            newSavedDeck = queryGateway.query(new FindDeckById(apiModel.getDeckId()), Deck.class).get();
            if (newSavedDeck.getCards().keySet().containsAll(apiModel.getCards().keySet())) {
                return new ResponseEntity<>("Adding cards was succesfull", HttpStatus.OK);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Adding cards was unsuccesfull", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Adding cards was unsuccesfull", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody DeleteDeckApiModel apiModel) {
        String id = UUID.randomUUID().toString();
        Deck savedDeck;

        try {
            savedDeck = queryGateway.query(new FindDeckById(apiModel.getDeckId()), Deck.class).get();
            if (savedDeck == null) {
                return new ResponseEntity<>("Deleting Deck was unsucessful", HttpStatus.BAD_REQUEST);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Deleting Deck was unsucessful", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        commandGateway.send(new DeleteDeck(id,apiModel.getDeckId()));
        try {
            savedDeck = queryGateway.query(new FindDeckById(apiModel.getDeckId()), Deck.class).get();
            if (savedDeck != null) {
                return new ResponseEntity<>("Deleting Deck was unsucessful", HttpStatus.BAD_REQUEST);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Deleting Deck was unsucessful", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Deleting deck was succesful", HttpStatus.OK);
    }

    @PostMapping("/removeCards")
    public ResponseEntity<String> removeCards(@RequestBody RemoveCardsApiModel apiModel) {
        String id = UUID.randomUUID().toString();
        Deck savedDeck;

        try {
            savedDeck = queryGateway.query(new FindDeckById(apiModel.getDeckId()), Deck.class).get();
            if (savedDeck == null) {
                return new ResponseEntity<>("Removing cards was unsucessful", HttpStatus.BAD_REQUEST);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Removing cards was unsucessful", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        commandGateway.send(new RemoveCards(id,apiModel.getDeckId(), apiModel.getCards()));
        return new ResponseEntity<>("Removing cards was succesfull", HttpStatus.OK);
    }

    @PostMapping("/renameDeck")
    public ResponseEntity<String> renameDeck(@RequestBody RenameDeck apiModel) {
        String id = UUID.randomUUID().toString();
        Deck savedDeck;

        try {
            savedDeck = queryGateway.query(new FindDeckById(apiModel.getDeckId()), Deck.class).get();
            if (savedDeck == null) {
                return new ResponseEntity<>("Renaming deck was unsucessful", HttpStatus.BAD_REQUEST);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Renaming deck was unsucessful", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        commandGateway.send(new RenameDeck(id,apiModel.getDeckId(), apiModel.getNewDeckName()));
        return new ResponseEntity<>("Renaming deck was succesfull", HttpStatus.OK);
    }

}
