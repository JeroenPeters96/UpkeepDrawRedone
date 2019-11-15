package upd.deckservice.Controllers.IncomingModels;

import java.util.Objects;

public class SetDeckFormatApiModel {
    private final String id;
    private final String deckId;
    private final String format;

    public SetDeckFormatApiModel(String id, String deckId, String format) {
        this.id = id;
        this.deckId = deckId;
        this.format = format;
    }

    public String getId() {
        return id;
    }

    public String getDeckId() {
        return deckId;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return "SetDeckFormatApiModel{" +
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                ", format='" + format + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetDeckFormatApiModel that = (SetDeckFormatApiModel) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDeckId(), that.getDeckId()) &&
                Objects.equals(getFormat(), that.getFormat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeckId(), getFormat());
    }
}
