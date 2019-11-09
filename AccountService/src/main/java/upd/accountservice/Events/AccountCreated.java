package upd.accountservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class AccountCreated  {

    @TargetAggregateIdentifier
    private final String id;
    private final String accountId;
    private final String email;
    private final String password;
    private final String username;

    public AccountCreated(String id, String accountId, String email, String password, String username) {
        this.id = id;
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "AccountCreated{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountCreated that = (AccountCreated) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getUsername(), that.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountId(), getEmail(), getPassword(), getUsername());
    }
}
