package upd.cardservice.Services;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import upd.cardservice.Models.Card;

import java.util.List;

@Service
public class CardApiService {

    private final CommandGateway commandGateway;

    public CardApiService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public List<String> autocompleteCall(String partialCardname) {
        return null;
    }

    public List<Card> getCardsBySet(String set) {
        return null;
    }

    public Card findCard(String cardName) {


    }
}
