package upd.collectionservice.Queries;

import java.util.Objects;

public class CollectionByAccount {
    private final String accountId;

    public CollectionByAccount(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "CollectionByAccount{" +
                "accountId='" + accountId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionByAccount that = (CollectionByAccount) o;
        return Objects.equals(getAccountId(), that.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId());
    }
}
