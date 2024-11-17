package Users;

import Main.Ticket;
import Main.Tickets;

public class Admin implements User {
    @Override
    public String printRole() {
        return "I am an admin";
    }

    public void checkTicket(String id) {
        Ticket ticket = Tickets.getTicketId(id);
        if(ticket == null) {
            System.out.println("Admin: Fake ticket or not found: " + id);
        } else {
            System.out.println("Admin: Welcome, " + id);
        }
    }
}
