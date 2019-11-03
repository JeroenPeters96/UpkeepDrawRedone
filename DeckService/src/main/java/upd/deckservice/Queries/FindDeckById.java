package upd.deckservice.Queries;

import java.util.Objects;

public class FindDeckById {

    private final String deckId;

    public FindDeckById(String deckId) {
        this.deckId = deckId;
    }

    public String getDeckId() {
        return deckId;
    }

    @Override
    public String toString() {
        return "FindDeckById{" +
                "deckId='" + deckId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FindDeckById)) return false;
        FindDeckById that = (FindDeckById) o;
        return Objects.equals(deckId, that.deckId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId);
    }
}
