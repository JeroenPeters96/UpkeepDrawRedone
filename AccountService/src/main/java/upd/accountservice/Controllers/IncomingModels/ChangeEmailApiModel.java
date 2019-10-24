package upd.accountservice.Controllers.IncomingModels;

public class ChangeEmailApiModel {
    private String accountId;
    private String newEmail;

    public ChangeEmailApiModel(String accountId, String newEmail) {
        this.accountId = accountId;
        this.newEmail = newEmail;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
