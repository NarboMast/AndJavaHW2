package ticketService;

public abstract class Indexable {
    private String id;

    public void setTicketId(String ticketId) {
        this.id = ticketId;
    }

    public String getTicketId() {
        return id;
    }
}
