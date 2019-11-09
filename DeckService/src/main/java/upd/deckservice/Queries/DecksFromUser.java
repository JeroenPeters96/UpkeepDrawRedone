package upd.deckservice.Queries;

import java.util.Objects;

public class DecksFromUser {

    private final String accountId;

    public DecksFromUser(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "DecksFromUser{" +
                "accountId='" + accountId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DecksFromUser)) return false;
        DecksFromUser that = (DecksFromUser) o;
        return Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }
}
