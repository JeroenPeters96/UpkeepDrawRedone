package upd.cardservice.Controllers.IncomingModels;

import java.util.List;

public class UpdateCardsApiModel {
    private final List<String> cards;

    public UpdateCardsApiModel(List<String> cards) {
        this.cards = cards;
    }

    public List<String> getCards() {
        return this.cards;
    }
}
