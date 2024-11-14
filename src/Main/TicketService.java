package Main;

public class TicketService extends Indexable{
    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Ticket ticket = tickets.getTicketId("dd10");
        System.out.println(ticket.print());

        System.out.println(ticket.shared("dd10"));
        System.out.println(ticket.shared("dd11", true));
    }
}
