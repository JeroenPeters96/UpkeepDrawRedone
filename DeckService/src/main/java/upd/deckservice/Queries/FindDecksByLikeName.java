package upd.deckservice.Queries;

import java.util.Objects;

public class FindDecksByLikeName {
    private final String deckName;

    public FindDecksByLikeName(String deckName) {
        this.deckName = deckName;
    }

    public String getDeckName() {
        return deckName;
    }

    @Override
    public String toString() {
        return "FindDecksByLikeName{" +
                "deckName='" + deckName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FindDecksByLikeName)) return false;
        FindDecksByLikeName that = (FindDecksByLikeName) o;
        return Objects.equals(deckName, that.deckName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckName);
    }
}
