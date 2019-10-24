package upd.accountservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class ChangeUsername   {
    @TargetAggregateIdentifier
    private final String accountId;
    private final String username;

    public ChangeUsername(String accountId, String username) {
        this.accountId = accountId;
        this.username = username;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "ChangeUsername{" +
                "accountId='" + accountId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChangeUsername)) return false;
        ChangeUsername that = (ChangeUsername) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, username);
    }
}
