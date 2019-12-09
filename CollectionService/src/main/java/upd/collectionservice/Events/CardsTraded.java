package upd.collectionservice.Events;

import upd.collectionservice.Models.CardCollection;

import java.util.List;
import java.util.Objects;

public class CardsTraded extends BaseEvent {
    private final String receiveAccountId;
    private final String sendAccountId;
    private final List<CardCollection> cards;

    public CardsTraded(String id, String receiveAccountId, String sendAccountId, List<CardCollection> cards) {
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
        return "CardsTrades{" +
                "receiveAccountId='" + receiveAccountId + '\'' +
                ", sendAccountId='" + sendAccountId + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CardsTraded that = (CardsTraded) o;
        return Objects.equals(getReceiveAccountId(), that.getReceiveAccountId()) &&
                Objects.equals(getSendAccountId(), that.getSendAccountId()) &&
                Objects.equals(getCards(), that.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getReceiveAccountId(), getSendAccountId(), getCards());
    }
}
