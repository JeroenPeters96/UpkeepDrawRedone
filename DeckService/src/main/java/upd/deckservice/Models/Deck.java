package upd.deckservice.Models;

import upd.deckservice.Events.DeckCreated;
import upd.deckservice.Events.DeckCreatedWithCards;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "Deck")
public class Deck implements Serializable {

    @Id
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private String id;

    @Column(name = "accountId",nullable = false,updatable = false)
    private String accountId;

    @Column(name = "deckname",nullable = false)
    private String deckname;

    @Column(name = "description")
    private String description;


    @ElementCollection
    @CollectionTable(name = "cardsindeck",
            joinColumns = @JoinColumn(name = "count"))
    @MapKeyJoinColumn(name = "cartId")
    @Column(name = "cardsindeck")
    private Map<Card,Integer> cards = new HashMap<>();

    private String format;

    private String deckArt;

    public Deck(String id, String accountId, String deckname, String description, Map<Card, Integer> cards, String format, String deckArt) {
        this.id = id;
        this.accountId = accountId;
        this.deckname = deckname;
        this.description = description;
        this.cards = cards;
        this.format = format;
        this.deckArt = deckArt;
    }

    public Deck(String id, String accountId, String deckname, String description, String format, String deckArt) {
        this.id = id;
        this.accountId = accountId;
        this.deckname = deckname;
        this.description = description;
        this.format = format;
        this.deckArt = deckArt;
    }

    public Deck(String id, String accountId, String deckname, String description, String format) {
        this.id = id;
        this.accountId = accountId;
        this.deckname = deckname;
        this.description = description;
        this.format = format;
        this.deckArt = "";
    }

    public Deck(DeckCreated event) {
     this.id = event.getDeckId();
     this.accountId = event.getAccountId();
     this.deckname = event.getName();
     this.description = event.getDescription();
     this.cards = new HashMap<>();
     this.format = event.getFormat();
     this.deckArt = "";
    }

    public Deck(DeckCreatedWithCards event) {
        this.id = event.getDeckId();
        this.accountId = event.getAccountId();
        this.deckname = event.getName();
        this.description = event.getDescription();
        this.cards = event.getCards();
        this.format = event.getFormat();
        this.deckArt = event.getCardArt();
    }

    public Deck() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDeckname() {
        return deckname;
    }

    public void setDeckname(String deckname) {
        this.deckname = deckname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Card, Integer> getCards() {
        return cards;
    }

    public void setCards(Map<Card, Integer> cards) {
        this.cards = cards;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDeckArt() {
        return deckArt;
    }

    public void setDeckArt(String deckArt) {
        this.deckArt = deckArt;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", deckname='" + deckname + '\'' +
                ", description='" + description + '\'' +
                ", cards=" + cards +
                ", format='" + format + '\'' +
                ", deckArt='" + deckArt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(getId(), deck.getId()) &&
                Objects.equals(getAccountId(), deck.getAccountId()) &&
                Objects.equals(getDeckname(), deck.getDeckname()) &&
                Objects.equals(getDescription(), deck.getDescription()) &&
                Objects.equals(getCards(), deck.getCards()) &&
                Objects.equals(getFormat(), deck.getFormat()) &&
                Objects.equals(getDeckArt(), deck.getDeckArt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getDeckname(), getDescription(), getCards(), getFormat(), getDeckArt());
    }
}
