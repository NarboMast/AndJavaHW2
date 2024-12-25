package sharedVia;

public class SharedViaPhone implements SharedVia{
    @Override
    public String sharedVia(String ticketId) {
        return ticketId + " is shared via phone";
    }
}
