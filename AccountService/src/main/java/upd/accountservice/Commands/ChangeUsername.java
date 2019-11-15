package upd.accountservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class ChangeUsername   {
    @TargetAggregateIdentifier
    private final String id;
    private final int accountId;
    private final String username;

    public ChangeUsername(String id, int accountId, String username) {
        this.id = id;
        this.accountId = accountId;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "ChangeUsername{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeUsername that = (ChangeUsername) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getUsername(), that.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getUsername());
    }
}
