package upd.accountservice.Controllers.IncomingModels;

public class ChangeEmailApiModel {
    private int accountId;
    private String newEmail;

    public ChangeEmailApiModel(int accountId, String newEmail) {
        this.accountId = accountId;
        this.newEmail = newEmail;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
