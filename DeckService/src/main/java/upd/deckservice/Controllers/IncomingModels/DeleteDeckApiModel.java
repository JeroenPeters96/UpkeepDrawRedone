package upd.deckservice.Controllers.IncomingModels;

import java.util.Objects;

public class DeleteDeckApiModel {
    private final String deckId;

    public DeleteDeckApiModel(String deckId) {
        this.deckId = deckId;
    }

    public String getDeckId() {
        return deckId;
    }

    @Override
    public String toString() {
        return "DeleteDeckApiModel{" +
                "deckId='" + deckId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeleteDeckApiModel)) return false;
        DeleteDeckApiModel that = (DeleteDeckApiModel) o;
        return Objects.equals(deckId, that.deckId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId);
    }
}
