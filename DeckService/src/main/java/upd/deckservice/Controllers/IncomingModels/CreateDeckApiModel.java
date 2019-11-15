package upd.deckservice.Controllers.IncomingModels;

import java.util.Objects;

public class CreateDeckApiModel {
    private final String accountId;
    private final String name;
    private final String description;
    private final String format;

    public CreateDeckApiModel(String accountId, String name, String description, String format) {
        this.accountId = accountId;
        this.name = name;
        this.description = description;
        this.format = format;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return "CreateDeckApiModel{" +
                "accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateDeckApiModel that = (CreateDeckApiModel) o;
        return Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getFormat(), that.getFormat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId(), getName(), getDescription(), getFormat());
    }
}
