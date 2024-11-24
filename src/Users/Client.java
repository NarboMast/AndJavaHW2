package Users;

import Main.Ticket;
import Main.TicketStorage;

public class Client implements User{
    private String clientId;

    public Client(String clientId){
        this.clientId = clientId;
    }

    @Override
    public String printRole() {
        return "I am a client under number: " + clientId;
    }

    public Ticket getTicket(String clientId) {
        for(Ticket ticket : TicketStorage.tickets){
            if(ticket.getClientId().equals(clientId)){
                return ticket;
            }
        }
        return null;
    }

    public String getClientId() {
        return clientId;
    }
}
