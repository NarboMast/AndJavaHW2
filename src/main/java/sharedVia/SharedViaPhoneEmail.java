package sharedVia;

public class SharedViaPhoneEmail implements SharedVia{
    @Override
    public String sharedVia(String ticketId) {
        return ticketId + " is shared via phone and email";
    }
}
