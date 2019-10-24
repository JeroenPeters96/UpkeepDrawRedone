package upd.accountservice.Queries;

public class FindAccountById {

    private final String id;

    public FindAccountById(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
