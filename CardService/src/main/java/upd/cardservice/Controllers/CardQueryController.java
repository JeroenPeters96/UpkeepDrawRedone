package upd.cardservice.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upd.cardservice.Models.Card;
import upd.cardservice.Queries.GetAutocomplete;
import upd.cardservice.Queries.GetCardByName;
import upd.cardservice.Queries.GetCardsById;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/cardqry")
@Api(value = "/qry",tags = {"Card Queries"})
@SwaggerDefinition( tags = {
        @Tag(name = "Card Queries",description = "Card related functionalities")
})
public class CardQueryController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Autowired
    public CardQueryController(CommandGateway commandGateway, @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public ResponseEntity<List<Card>> getCards(@RequestBody List<String> cardIds) {
        if (cardIds == null || cardIds.size() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Card> cards;
        try {
            cards = queryGateway.query(
                    new GetCardsById(cardIds), List.class).get();
            if (cards.size() != 0)
                return new ResponseEntity<>(cards, HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAutocomplete/{name}")
    public ResponseEntity<List<String>> getAutocompletes(@PathVariable String name) {
        if(name.equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<String> cardnames;
        try {
            cardnames = queryGateway.query(
                    new GetAutocomplete(name),List.class).get();
            if(cardnames.size()!=0)
            return new ResponseEntity<>(cardnames,HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Card> getCardByName(@PathVariable String name) {
        if(name.equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Card card;
        try {
            card = queryGateway.query(
                    new GetCardByName(name),Card.class).get();
            if(card!=null)
                return new ResponseEntity<>(card,HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/set/{setname}")
    public ResponseEntity<List<Card>> getCardsBySet(@PathVariable String setname) {
        return null;
    }
}
