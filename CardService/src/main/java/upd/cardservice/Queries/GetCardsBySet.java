package upd.cardservice.Queries;

import java.util.Objects;

public class GetCardsBySet {

    private final String set;

    public GetCardsBySet(String set) {
        this.set = set;
    }

    public String getSet() {
        return set;
    }

    @Override
    public String toString() {
        return "GetCardsBySet{" +
                "set='" + set + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCardsBySet that = (GetCardsBySet) o;
        return Objects.equals(getSet(), that.getSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSet());
    }
}
