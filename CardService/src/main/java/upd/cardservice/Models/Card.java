package upd.cardservice.Models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Card")
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String cardname;

    private int cmc;

    @ElementCollection
    private List<String> colors;

    private String type;

    private String setName;

    private String setId;

    private String text;

    private String imageUrl;

    private String artUrl;

    private String manaCost;

    public Card() {
    }

    public Card(String cardname, int cmc, List<String> colors, String type, String setName, String setId, String text, String imageUrl, String artUrl, String manaCost) {
        this.cardname = cardname;
        this.cmc = cmc;
        this.colors = colors;
        this.type = type;
        this.setName = setName;
        this.setId = setId;
        this.text = text;
        this.imageUrl = imageUrl;
        this.artUrl = artUrl;
        this.manaCost = manaCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public int getCmc() {
        return cmc;
    }

    public void setCmc(int cmc) {
        this.cmc = cmc;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getArtUrl() {
        return artUrl;
    }

    public void setArtUrl(String artUrl) {
        this.artUrl = artUrl;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", cardname='" + cardname + '\'' +
                ", cmc=" + cmc +
                ", colors=" + colors +
                ", type='" + type + '\'' +
                ", setName='" + setName + '\'' +
                ", setId='" + setId + '\'' +
                ", text='" + text + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", artUrl='" + artUrl + '\'' +
                ", manaCost='" + manaCost + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return cmc == card.cmc &&
                Objects.equals(id, card.id) &&
                Objects.equals(cardname, card.cardname) &&
                Objects.equals(colors, card.colors) &&
                Objects.equals(type, card.type) &&
                Objects.equals(setName, card.setName) &&
                Objects.equals(setId, card.setId) &&
                Objects.equals(text, card.text) &&
                Objects.equals(imageUrl, card.imageUrl) &&
                Objects.equals(artUrl, card.artUrl) &&
                Objects.equals(manaCost, card.manaCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardname, cmc, colors, type, setName, setId, text, imageUrl, artUrl, manaCost);
    }
}
