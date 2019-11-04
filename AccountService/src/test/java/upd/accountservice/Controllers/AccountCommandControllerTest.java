package upd.accountservice.Controllers;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import upd.accountservice.Controllers.IncomingModels.RegisterApiModel;
import upd.accountservice.Queries.FindAccountById;

import javax.persistence.EntityManager;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@PrepareForTest({UUID.class})
@RunWith(PowerMockRunner.class)

@DataJpaTest
@AutoConfigureTestEntityManager
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
class AccountCommandControllerTest {

    @MockBean
    private CommandGateway commandGateway;
    @MockBean
    private QueryGateway queryGateway;
    @Autowired private EntityManager entityManager;

    @Test
    void injectedComponentsAreNotNull(){

        assertThat(entityManager).isNotNull();
    }

    @Test
    void register() {
        RegisterApiModel model = new RegisterApiModel(
                "jeroen.peters@home.nl",
                "zetta",
                "password");

        PowerMockito.mockStatic(UUID.class);

        when(UUID.randomUUID().toString()).thenReturn("testUUID");


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
