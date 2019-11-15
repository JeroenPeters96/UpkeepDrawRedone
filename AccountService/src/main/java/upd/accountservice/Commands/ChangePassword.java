package upd.accountservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class ChangePassword {
    @TargetAggregateIdentifier
    private final String id;
    private final int accountId;
    private final String newPassword;

    public ChangePassword(String id, int accountId, String newPassword) {
        this.id = id;
        this.accountId = accountId;
        this.newPassword = newPassword;
    }

    public String getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    @Override
    public String toString() {
        return "ChangePassword{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangePassword that = (ChangePassword) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getNewPassword(), that.getNewPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getNewPassword());
    }
}
