package upd.accountservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class UsernameChanged  {

    @TargetAggregateIdentifier
    private final String id;
    private final int accountId;
    private final String newUsername;

    public UsernameChanged(String id, int accountId, String newUsername) {
        this.id = id;
        this.accountId = accountId;
        this.newUsername = newUsername;
    }

    public String getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getNewUsername() {
        return newUsername;
    }

    @Override
    public String toString() {
        return "UsernameChanged{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", newUsername='" + newUsername + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsernameChanged that = (UsernameChanged) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getNewUsername(), that.getNewUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getNewUsername());
    }
}
