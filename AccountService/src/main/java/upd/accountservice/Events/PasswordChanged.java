package upd.accountservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class PasswordChanged {
    @TargetAggregateIdentifier
    private final String accountId;
    private final String newPassword;

    public PasswordChanged(String accountId, String newPassword) {
        this.accountId = accountId;
        this.newPassword = newPassword;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    @Override
    public String toString() {
        return "PasswordChanged{" +
                "accountId='" + accountId + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PasswordChanged)) return false;
        PasswordChanged that = (PasswordChanged) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(newPassword, that.newPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, newPassword);
    }
}
