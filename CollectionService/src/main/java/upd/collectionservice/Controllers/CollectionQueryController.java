package upd.collectionservice.Controllers;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.responsetypes.ResponseTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upd.collectionservice.Models.CardCollection;
import upd.collectionservice.Queries.CollectionByAccount;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/qry")
public class CollectionQueryController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Autowired
    public CollectionQueryController(final CommandGateway commandGateway, final QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{accId}")
    public ResponseEntity<List<CardCollection>> getCollection(@PathVariable String accId) {
        try {
            List<CardCollection> collections = queryGateway.query(
                    new CollectionByAccount(accId), ResponseTypes.multipleInstancesOf(CardCollection.class)).get();
            if(collections!=null) {
                return new ResponseEntity<>(collections, HttpStatus.OK);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
