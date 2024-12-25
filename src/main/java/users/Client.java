package users;

import ticketService.Ticket;
import ticketService.TicketStorage;

public class Client extends User {
    private Role role;
    private String clientId;

    public Client(User user, String clientId) {
        super(user.getName());
        this.clientId = clientId;
        this.role = Role.CLIENT;
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
