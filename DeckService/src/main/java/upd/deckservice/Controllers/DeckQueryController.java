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
@Api(value = "/qry",tags = {"Account upd.edhrecservice.upd.collectionservice.Queries"})
@SwaggerDefinition( tags = {
        @Tag(name = "Deck upd.edhrecservice.upd.collectionservice.Queries",description = "Deck related functionalities")
})
public class DeckQueryController {

    private final QueryGateway queryGateway;

    @Autowired
    public DeckQueryController(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") QueryGateway queryGateway) {
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
            List found = queryGateway.query(new DecksFromUser(id),ResponseTypes.multipleInstancesOf(Deck.class)).get();
            List<Deck> foundDecks = found;
            System.out.println(foundDecks);
            if(foundDecks!=null && foundDecks.size() != 0) {
                return new ResponseEntity<>(foundDecks,HttpStatus.OK);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/name/{name}")
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

    @GetMapping("/meta")
    public ResponseEntity<List<Deck>> getMetaDecks() {
        try {
            List<Deck> foundDecks = queryGateway.query(new DecksFromUser("6969"),ResponseTypes.multipleInstancesOf(Deck.class)).get();
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
