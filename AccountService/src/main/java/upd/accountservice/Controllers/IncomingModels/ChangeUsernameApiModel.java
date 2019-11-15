package upd.accountservice.Controllers.IncomingModels;

public class ChangeUsernameApiModel {

    private int accountId;
    private String username;

    public ChangeUsernameApiModel(int accountId, String username) {
        this.accountId = accountId;
        this.username = username;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
