package upd.deckservice.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.responsetypes.ResponseTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upd.deckservice.Models.Deck;
import upd.deckservice.Queries.DecksFromUser;
import upd.deckservice.Queries.FindDeckById;
import upd.deckservice.Queries.FindDecksByLikeName;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/qry")
@Api(value = "/qry",tags = {"Account upd.edhrecservice.Queries"})
@SwaggerDefinition( tags = {
        @Tag(name = "Deck upd.edhrecservice.Queries",description = "Deck related functionalities")
})
public class DeckQueryController {

    private final QueryGateway queryGateway;

    @Autowired
    public DeckQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deck> getDeckById(@PathVariable String id) {
        System.out.println(id);
        try {
            Deck foundDeck = queryGateway.query(new FindDeckById(id),Deck.class).get();
            if(foundDeck!=null) {
                return new ResponseEntity<>(foundDeck, HttpStatus.OK);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Deck>> getDecksByUser(@PathVariable String id) {

        try {
            List found = queryGateway.query(new DecksFromUser(id),List.class).get();
            List<Deck> foundDecks = found;

            if(foundDecks!=null && foundDecks.size() != 0) {
                return new ResponseEntity<>(foundDecks,HttpStatus.OK);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/naem/{name}")
    public ResponseEntity<List<Deck>> getLikeDeckName(@PathVariable String name) {
        if(name.equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            List<Deck> foundDecks = queryGateway.query(new FindDecksByLikeName(name), ResponseTypes.multipleInstancesOf(Deck.class)).get();
            if(foundDecks!=null && foundDecks.size() != 0) {
                return new ResponseEntity<>(foundDecks,HttpStatus.OK);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
