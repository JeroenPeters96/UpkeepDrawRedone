package upd.cardservice.Queries;

import java.util.Objects;

public class GetAutocomplete {
    private final String partialCardname;

    public GetAutocomplete(String partialCardname) {
        this.partialCardname = partialCardname;
    }

    public String getPartialCardname() {
        return partialCardname;
    }

    @Override
    public String toString() {
        return "GetAutocomplete{" +
                "partialCardname='" + partialCardname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAutocomplete)) return false;
        GetAutocomplete that = (GetAutocomplete) o;
        return Objects.equals(partialCardname, that.partialCardname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partialCardname);
    }
}
