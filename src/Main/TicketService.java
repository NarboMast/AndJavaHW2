package Main;

import Users.Admin;
import Users.Client;

public class TicketService extends Indexable{
    public static void main(String[] args) {
        TicketStorage ticketStorage = new TicketStorage();
        Ticket ticket = ticketStorage.getTicketById("dd01");
        System.out.println(ticket.print());
        System.out.println(ticket.share());

        Client client = new Client("PE123456789");
        System.out.println(client.printRole() + " and i own a ticket under id: " + ticket.getId());
        Admin admin = new Admin();
        System.out.println(admin.printRole());
        admin.checkTicketById(ticket.getId());
        admin.checkTicketByClientId(client.getClientId());
    }
}
