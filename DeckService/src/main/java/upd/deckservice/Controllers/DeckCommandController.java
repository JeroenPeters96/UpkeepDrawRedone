package upd.deckservice.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upd.deckservice.Commands.CreateDeck;
import upd.deckservice.Commands.CreateDeckWithCards;
import upd.deckservice.Controllers.IncomingModels.CreateDeckApiModel;
import upd.deckservice.Controllers.IncomingModels.CreateDeckWithCardsApiModel;
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
public class DeckCommandController {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Autowired
    public DeckCommandController(final CommandGateway commandGateway, final QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDeck(@RequestBody CreateDeckApiModel apiModel) {
        String deckId = UUID.randomUUID().toString();
        commandGateway.send(new CreateDeck(
                deckId,
                apiModel.getAccountId(),
                apiModel.getName(),
                apiModel.getDescription()
        ));

        Deck savedDeck;

        try {
            savedDeck = queryGateway.query(new FindDeckById(deckId),Deck.class).get();
            if(savedDeck.getId().equals(deckId) &&
            savedDeck.getAccountId().equals(apiModel.getAccountId()) &&
            savedDeck.getDeckname().equals(apiModel.getName()) &&
            savedDeck.getCards().isEmpty()) {
                return new ResponseEntity<>("Deck creation succesfull", HttpStatus.OK);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Deck creation unsuccesfull",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Deck creation unsuccesfull",HttpStatus.NOT_FOUND);
    }


    @PostMapping("/CreateCards")
    public ResponseEntity<String> createWithCards(@RequestBody CreateDeckWithCardsApiModel apiModel) {
            String deckId = UUID.randomUUID().toString();
            commandGateway.send(new CreateDeckWithCards(
                    deckId,
                    apiModel.getAccountId(),
                    apiModel.getName(),
                    apiModel.getDescription(),
                    apiModel.getCards()
            ));

    }

}
