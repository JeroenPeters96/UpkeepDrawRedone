package upd.accountservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class CreateAccount  {

    @TargetAggregateIdentifier
    private final String accountId;
    private final String email;
    private final String password;
    private final String username;

    public CreateAccount(String accountId, String email, String password, String username) {
       this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.username = username;
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

    public String getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "CreateAccount{" +
                "accountId='" + accountId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateAccount)) return false;
        CreateAccount that = (CreateAccount) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, email, password, username);
    }
}
