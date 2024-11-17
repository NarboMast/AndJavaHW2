package Users;

import Enums.*;
import Main.Ticket;
import Main.Tickets;

public class Client implements User{
    @Override
    public String printRole() {
        return "I am a client";
    }

    public void getTicket(Ticket ticket) {
        Tickets.addTicket(ticket);
    }
}
