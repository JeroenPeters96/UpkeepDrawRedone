package upd.accountservice.Controllers.IncomingModels;

public class ChangePasswordApiModel {

    private int accountId;
    private String password;

    public ChangePasswordApiModel(int accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
