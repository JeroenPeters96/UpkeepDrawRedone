package upd.cardservice.Models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Card")
public class Card implements Serializable {

    @Id
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String cardname;

    private int cmc;

    @ElementCollection
    private List<String> colors;

    private String type;

    @ElementCollection
    private List<String> subtype;

    private String setName;

    private String text;

    private String imageUrl;


    public Card() {
    }


    public Card(String id, String cardname, int cmc, List<String> colors, String type, List<String> subtype, String setName, String text, String imageUrl) {
        this.id = id;
        this.cardname = cardname;
        this.cmc = cmc;
        this.colors = colors;
        this.type = type;
        this.subtype = subtype;
        this.setName = setName;
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(getId(), card.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
