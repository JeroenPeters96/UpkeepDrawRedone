package upd.accountservice.Controllers.IncomingModels;

public class ChangeUsernameApiModel {

    private String accountId;
    private String username;

    public ChangeUsernameApiModel(String accountId, String username) {
        this.accountId = accountId;
        this.username = username;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
