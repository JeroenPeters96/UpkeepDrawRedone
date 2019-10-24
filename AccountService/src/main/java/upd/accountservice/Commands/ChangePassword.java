package upd.accountservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class ChangePassword {
    @TargetAggregateIdentifier
    private final String accountId;
    private final String newPassword;

    public ChangePassword(String accountId, String newPassword) {
        this.accountId = accountId;
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "ChangePassword{" +
                "accountId='" + accountId + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChangePassword)) return false;
        ChangePassword that = (ChangePassword) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(newPassword, that.newPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, newPassword);
    }
}
