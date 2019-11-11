package upd.cardservice.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qry")
@Api(value = "/qry",tags = {"Card Queries"})
@SwaggerDefinition( tags = {
        @Tag(name = "Card Queries",description = "Card related functionalities")
})
public class CardQueryController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Autowired
    public CardQueryController(CommandGateway commandGateway, @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }


}

