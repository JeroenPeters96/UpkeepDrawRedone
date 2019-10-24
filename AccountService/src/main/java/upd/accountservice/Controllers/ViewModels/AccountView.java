package upd.accountservice.Controllers.ViewModels;

import upd.accountservice.Models.Account;

public class AccountView {

    private final String email;
    private final String username;
    private final String password;
    private final String token;

    public AccountView(Account account, String token) {
        this.email = account.getEmail();
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.token = token;
    }
}
