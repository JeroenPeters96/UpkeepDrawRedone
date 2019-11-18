//package upd.accountservice.Controllers;
//
//import org.axonframework.commandhandling.gateway.CommandGateway;
//import org.axonframework.queryhandling.QueryGateway;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import upd.accountservice.Controllers.IncomingModels.RegisterApiModel;
//import upd.accountservice.Models.Account;
//import upd.accountservice.Queries.FindAccountById;
//
//import javax.persistence.EntityManager;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.BDDMockito.*;
//
//
//@RunWith(SpringRunner.class)
//@ActiveProfiles("test")
////@WebMvcTest(AccountCommandController.class)
//class AccountCommandControllerTest {
//
//    @Mock
//    private CommandGateway commandGateway;
//
//    @Mock
//    private QueryGateway queryGateway;
//
//
//    private AccountCommandController commandController = new AccountCommandController(commandGateway,queryGateway);
//
//    @Autowired
//    private MockMvc mvc;
//
//    private Account account1;
//    private Account account2;
//    private List<Account> accountList;
//
//    @BeforeEach
//    void setup() {
//        this.account1 = new Account("test@test.nl","pass","user1");
//        this.account2 = new Account("test2@test.nl","password","user2");
//        accountList = new ArrayList<>();
//        accountList.add(account1);
//        accountList.add(account2);
//    }
//
//    @Test
//    void injectedComponentsAreNotNull(){
//        assertThat(commandController.getCommandGateway()).isNotNull();
//        assertThat(commandController.getQueryGateway()).isNotNull();
//        //assertThat(mvc).isNotNull();
//    }
//
//    @Test
//    void register() {
//        RegisterApiModel model = new RegisterApiModel(
//                account1.getEmail(),
//                account1.getUsername(),
//                account1.getPassword());
//
//
//    }
//
//    @Test
//    void delete() {
//    }
//
//    @Test
//    void changeEmail() {
//    }
//
//    @Test
//    void changeUsername() {
//    }
//
//    @Test
//    void changePassword() {
//    }
//}
