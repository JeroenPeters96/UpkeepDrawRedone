package upd.accountservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class EmailChanged {

    @TargetAggregateIdentifier
    private final String id;
    private final String accountId;
    private final String email;

    public EmailChanged(String id, String accountId, String email) {
        this.id = id;
        this.accountId = accountId;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "EmailChanged{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailChanged that = (EmailChanged) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getEmail());
    }
}
