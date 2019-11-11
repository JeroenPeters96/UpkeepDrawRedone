package upd.cardservice.Queries;

public class GetCardByName {
    private final String cardName;

    public GetCardByName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }
}
