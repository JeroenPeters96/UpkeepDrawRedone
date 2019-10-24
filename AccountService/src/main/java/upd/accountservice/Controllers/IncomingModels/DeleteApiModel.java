package upd.accountservice.Controllers.IncomingModels;

public class DeleteApiModel {

    private String accountId;

    public DeleteApiModel(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
