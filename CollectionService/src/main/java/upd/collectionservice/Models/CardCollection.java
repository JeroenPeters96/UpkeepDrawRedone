package upd.collectionservice.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "CardCollection")
public class CardCollection {
    @Id
    @GeneratedValue
    private int id;
    private String accountId;
    private String cardId;
    private int count;

    public CardCollection(int id, String accountId, String cardId, int count) {
        this.id = id;
        this.accountId = accountId;
        this.cardId = cardId;
        this.count = count;
    }

    public CardCollection() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
        return "CardCollection{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", cardId='" + cardId + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardCollection that = (CardCollection) o;
        return getId() == that.getId() &&
                getCount() == that.getCount() &&
                Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getCardId(), that.getCardId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getCardId(), getCount());
    }
}
