package upd.deckservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreateDeck {
    @TargetAggregateIdentifier
    private String deckId;
    private String accountId;
    private String name;
    private String description;

    public CreateDeck(String deckId, String accountId, String name, String description) {
        this.deckId = deckId;
        this.accountId = accountId;
        this.name = name;
        this.description = description;
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
