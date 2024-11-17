package Main;

import Enums.PromoStatus;
import Enums.StadiumSector;
import Users.Admin;
import Users.Client;

import java.sql.Timestamp;

public class TicketService extends Indexable{
    public static void main(String[] args) {
        new Tickets();
        Ticket ticket = Tickets.getTicketId("dd04");
        System.out.println(ticket.toString());
        System.out.println(ticket.shared(ticket));

        Client client = new Client();
        Ticket ticket2 = new Ticket("aaaa", "1234567890", (short) 123, Timestamp.valueOf("2024-12-20 20:00:00"), PromoStatus.YES, StadiumSector.A, 10.999f, null);
        client.getTicket(ticket2);
        Admin admin = new Admin();
        admin.checkTicket(ticket2.getId());
        admin.checkTicket("HBdfs");
    }
}
