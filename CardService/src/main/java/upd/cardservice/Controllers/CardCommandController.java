package upd.cardservice.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upd.cardservice.Commands.UpdateCards;
import upd.cardservice.Controllers.IncomingModels.UpdateCardsApiModel;

import java.util.UUID;

@RestController
@RequestMapping("/cmd")
@Api(value = "/cmd",tags = {"Card Commands"})
@SwaggerDefinition( tags = {
        @Tag(name = "Card Commands",description = "Card related functionalities")
})
public class CardCommandController {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Autowired
    public CardCommandController(final CommandGateway commandGateway, @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") final QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping
    public void updateCards(@RequestBody UpdateCardsApiModel apiModel) {
        commandGateway.send(
                new UpdateCards(
                        UUID.randomUUID().toString(),
                        apiModel.getCards()
                )
        );
    }

}
