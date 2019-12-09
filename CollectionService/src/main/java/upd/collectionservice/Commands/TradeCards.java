package upd.collectionservice.Commands;

import upd.collectionservice.Models.CardCollection;

import java.util.List;
import java.util.Objects;

public class TradeCards extends BaseCommand {

    private final String receiveAccountId;
    private final String sendAccountId;
    private final List<CardCollection> cards;

    public TradeCards(String id, String receiveAccountId, String sendAccountId, List<CardCollection> cards) {
        super(id);
        this.receiveAccountId = receiveAccountId;
        this.sendAccountId = sendAccountId;
        this.cards = cards;
    }

    public String getReceiveAccountId() {
        return receiveAccountId;
    }

    public String getSendAccountId() {
        return sendAccountId;
    }

    public List<CardCollection> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "TradeCards{" +
                "receiveAccountId='" + receiveAccountId + '\'' +
                ", sendAccountId='" + sendAccountId + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeCards that = (TradeCards) o;
        return Objects.equals(getReceiveAccountId(), that.getReceiveAccountId()) &&
                Objects.equals(getSendAccountId(), that.getSendAccountId()) &&
                Objects.equals(getCards(), that.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReceiveAccountId(), getSendAccountId(), getCards());
    }
}
