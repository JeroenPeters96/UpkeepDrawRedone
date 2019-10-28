package upd.deckservice.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upd.deckservice.Models.Deck;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/qry")
@Api(value = "/qry",tags = {"Account Queries"})
@SwaggerDefinition( tags = {
        @Tag(name = "Deck Queries",description = "Deck related functionalities")
})
public class DeckQueryController {

    private final QueryGateway queryGateway;

    @Autowired
    public DeckQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/id")
    public ResponseEntity<Deck> getDeckById(@RequestBody String id) {
        try {
            Deck foundDeck = queryGateway.query(getDeckById(id),Deck.class).get();
            if(foundDeck!=null) {
                return new ResponseEntity<>(foundDeck, HttpStatus.OK);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Deck>> getDecksByUser(@RequestBody String id) {
        try {
            List<Deck> foundDecks = queryGateway.query(getDecksByUser(id),List.class).get();
            if(foundDecks!=null && foundDecks.size() != 0) {
                return new ResponseEntity<>(foundDecks,HttpStatus.OK);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

}
