package upd.deckservice.Controllers.IncomingModels;

import java.util.Objects;

public class CreateDeckApiModel {
    private final String accountId;
    private final String name;
    private final String description;

    public CreateDeckApiModel(String accountId, String name, String description) {
        this.accountId = accountId;
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "CreateDeckApiModel{" +
                "accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateDeckApiModel)) return false;
        CreateDeckApiModel that = (CreateDeckApiModel) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, name, description);
    }
}
