package upd.accountservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class EmailChanged {
    @TargetAggregateIdentifier
    private final String accountId;
    private final String email;

    public EmailChanged(String accountId, String email) {
        this.accountId = accountId;
        this.email = email;
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
                "accountId='" + accountId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailChanged)) return false;
        EmailChanged that = (EmailChanged) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, email);
    }
}
