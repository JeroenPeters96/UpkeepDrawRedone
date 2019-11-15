package upd.accountservice.Controllers.IncomingModels;

public class DeleteApiModel {

    private int accountId;

    public DeleteApiModel(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
