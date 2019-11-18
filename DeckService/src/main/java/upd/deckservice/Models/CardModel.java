package upd.deckservice.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CardModel")
public class CardModel {

    @Id
    private String id;
    private String cardId;
    private int count;

    public CardModel(String id,  String cardId, int count) {
        this.id = id;
        this.cardId = cardId;
        this.count = count;
    }

    public CardModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CardModel{" +
                "id='" + id + '\'' +
                ", cardId='" + cardId + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardModel cardModel = (CardModel) o;
        return getCount() == cardModel.getCount() &&
                Objects.equals(getId(), cardModel.getId()) &&
                Objects.equals(getCardId(), cardModel.getCardId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),  getCardId(), getCount());
    }
}
