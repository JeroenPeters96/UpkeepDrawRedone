package upd.accountservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class ChangeEmail  {
    @TargetAggregateIdentifier
    private final String accountId;
    private final String email;

    public ChangeEmail(String accountId, String email) {
        this.accountId = accountId;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "ChangeEmail{" +
                "accountId='" + accountId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChangeEmail)) return false;
        ChangeEmail that = (ChangeEmail) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, accountId);
    }
}
