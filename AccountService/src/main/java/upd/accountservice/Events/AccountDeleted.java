package upd.accountservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class AccountDeleted {

    @TargetAggregateIdentifier
    private final String id;
    private final String accountId;

    public AccountDeleted(String id, String accountId) {
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
        return "AccountDeleted{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDeleted that = (AccountDeleted) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAccountId(), that.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId());
    }
}
