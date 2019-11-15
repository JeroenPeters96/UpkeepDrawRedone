package upd.accountservice.Controllers.IncomingModels;

import java.util.Objects;

public class GetAccountByIdApiModel {
    private final int accountId;

    public GetAccountByIdApiModel(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "GetAccountByIdApiModel{" +
                "accountId='" + accountId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAccountByIdApiModel)) return false;
        GetAccountByIdApiModel that = (GetAccountByIdApiModel) o;
        return Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }
}
