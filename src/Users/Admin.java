package Users;

import Main.Ticket;
import Main.TicketStorage;

public class Admin implements User {
    @Override
    public String printRole() {
        return "I am an admin";
    }

    public void checkTicketById(String id) {
        Ticket ticket = TicketStorage.getTicketById(id);
        if(ticket == null) {
            System.out.println("Admin: Fake ticket or not found: " + id);
        } else {
            System.out.println("Admin: Welcome, " + ticket.getClientId());
        }
    }

    public void checkTicketByClientId(String clietnId){
        Ticket ticket = TicketStorage.getTicketByClientId(clietnId);
        if(ticket == null) {
            System.out.println("Admin: Fake ticket or not found");
        } else {
            System.out.println("Admin: Welcome, " + clietnId);
        }
    }
}
