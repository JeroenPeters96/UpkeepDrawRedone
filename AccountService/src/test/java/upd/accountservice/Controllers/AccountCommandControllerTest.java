package upd.accountservice.Controllers;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountCommandController.class)
class AccountCommandControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QueryGateway queryGateway;

    @MockBean
    private CommandGateway commandGateway;

    @Test
    void register() {

    }

    @Test
    void delete() {

    }

    @Test
    void changeEmail() {

    }

    @Test
    void changeUsername() {

    }

    @Test
    void changePassword() {

    }
}