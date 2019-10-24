package upd.accountservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class UsernameChanged  {
    @TargetAggregateIdentifier
    private final String accountId;
    private final String newUsername;

    public UsernameChanged(String accountId, String newUsername) {
        this.accountId = accountId;
        this.newUsername = newUsername;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getNewUsername() {
        return newUsername;
    }

    @Override
    public String toString() {
        return "UsernameChanged{" +
                "accountId='" + accountId + '\'' +
                ", newUsername='" + newUsername + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsernameChanged)) return false;
        UsernameChanged that = (UsernameChanged) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(newUsername, that.newUsername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, newUsername);
    }
}
