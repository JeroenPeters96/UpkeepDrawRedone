package upd.deckservice.Controllers.IncomingModels;

import java.util.Objects;

public class RenameDeckApiModel {
    private final String deckId;
    private final String newDeckName;

    public RenameDeckApiModel(String deckId, String newDeckName) {
        this.deckId = deckId;
        this.newDeckName = newDeckName;
    }

    public String getDeckId() {
        return deckId;
    }

    public String getNewDeckName() {
        return newDeckName;
    }

    @Override
    public String toString() {
        return "RenameDeckApiModel{" +
                "deckId='" + deckId + '\'' +
                ", newDeckName='" + newDeckName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RenameDeckApiModel)) return false;
        RenameDeckApiModel that = (RenameDeckApiModel) o;
        return Objects.equals(deckId, that.deckId) &&
                Objects.equals(newDeckName, that.newDeckName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId, newDeckName);
    }
}
