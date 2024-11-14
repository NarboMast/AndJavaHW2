package Main;

import Enums.StadiumSector;
import Enums.PromoStatus;

import java.sql.Timestamp;

public class TicketService {
    private Ticket[] tickets;

    public TicketService() {
        tickets = new Ticket[10];
        tickets[0] = new Ticket("dd01", "1234567890", (short) 123, Timestamp.valueOf("2024-12-20 20:00:00"), PromoStatus.YES, StadiumSector.A, 10.999f);
        tickets[1] = new Ticket("dd01", "1234567891", (short) 124, Timestamp.valueOf("2024-12-21 20:00:00"), PromoStatus.NO, StadiumSector.B, 15.999f);
        tickets[2] = new Ticket("dd03", "1234567892", (short) 125, Timestamp.valueOf("2024-12-22 20:00:00"), PromoStatus.YES, StadiumSector.C, 12.999f);
        tickets[3] = new Ticket("dd03", "1234567893", (short) 126, Timestamp.valueOf("2024-12-23 20:00:00"), PromoStatus.NO, StadiumSector.A, 18.999f);
        tickets[4] = new Ticket("dd04", "1234567894", (short) 127, Timestamp.valueOf("2024-12-24 20:00:00"), PromoStatus.YES, StadiumSector.B, 13.999f);
        tickets[5] = new Ticket("dd05", "1234567895", (short) 128, Timestamp.valueOf("2024-12-25 20:00:00"), PromoStatus.NO, StadiumSector.C, 17.999f);
        tickets[6] = new Ticket("dd06", "1234567896", (short) 129, Timestamp.valueOf("2024-12-26 20:00:00"), PromoStatus.YES, StadiumSector.A, 14.999f);
        tickets[7] = new Ticket("dd07", "1234567897", (short) 130, Timestamp.valueOf("2024-12-27 20:00:00"), PromoStatus.NO, StadiumSector.B, 11.999f);
        tickets[8] = new Ticket("dd09", "1234567898", (short) 131, Timestamp.valueOf("2024-12-28 20:00:00"), PromoStatus.YES, StadiumSector.C, 16.999f);
        tickets[9] = new Ticket("dd10", "1234567899", (short) 132, Timestamp.valueOf("2024-12-29 20:00:00"), PromoStatus.NO, StadiumSector.A, 19.999f);
    }

    public Ticket getTicketId(String id) {
        for (Ticket ticket : tickets) {
            if (ticket != null && ticket.getID().equals(id)) {
                return ticket;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TicketService service = new TicketService();
        Ticket ticket = service.getTicketId("dd10");
        System.out.println(ticket.toString());
    }
}
