package upd.accountservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class DeleteAccount {
    @TargetAggregateIdentifier
    private final String id;
    private final String accountId;

    public DeleteAccount(String id, String accountId) {
        this.id = id;
        this.accountId = accountId;
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "DeleteAccount{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteAccount that = (DeleteAccount) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAccountId(), that.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId());
    }
}
