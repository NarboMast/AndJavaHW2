package Main;

import Enums.*;
import Enums.SharedType;

import java.sql.Timestamp;
import java.util.ArrayList;

public class TicketStorage {
    public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();;

    public TicketStorage() {
        tickets.add(new Ticket("dd01", "1234567890", (short) 123, Timestamp.valueOf("2024-12-20 20:00:00"), PromoStatus.YES, StadiumSector.A, 10.999f, null, "PE123456789"));
        tickets.add(new Ticket("dd02", "1234567891", (short) 124, Timestamp.valueOf("2024-12-21 20:00:00"), PromoStatus.NO, StadiumSector.B, 15.999f, SharedType.PHONE,"PE123456788"));
        tickets.add(new Ticket("dd03", "1234567894", (short) 127, Timestamp.valueOf("2024-12-24 20:00:00"), PromoStatus.YES, StadiumSector.B, 13.999f, null,"PE123456787"));
        tickets.add(new Ticket("dd04", "1234567893", (short) 126, Timestamp.valueOf("2024-12-23 20:00:00"), PromoStatus.NO, StadiumSector.A, 18.999f, SharedType.PHONE_EMAIL,"PE123456786"));
        tickets.add(new Ticket("dd05", "1234567895", (short) 128, Timestamp.valueOf("2024-12-25 20:00:00"), PromoStatus.NO, StadiumSector.C, 17.999f, SharedType.PHONE_EMAIL,"PE123456785"));
        tickets.add(new Ticket("dd06", "1234567896", (short) 129, Timestamp.valueOf("2024-12-26 20:00:00"), PromoStatus.YES, StadiumSector.A, 14.999f, SharedType.PHONE,"PE123456784"));
        tickets.add(new Ticket("dd07", "1234567897", (short) 130, Timestamp.valueOf("2024-12-27 20:00:00"), PromoStatus.NO, StadiumSector.B, 11.999f, null,"PE123456783"));
        tickets.add(new Ticket("dd09", "1234567898", (short) 131, Timestamp.valueOf("2024-12-28 20:00:00"), PromoStatus.YES, StadiumSector.C, 16.999f, null,"PE123456782"));
    }

    public static Ticket getTicketById(String id) {
        for (Ticket ticket : tickets) {
            if (ticket != null && ticket.getId().equals(id)) {
                return ticket;
            }
        }
        return null;
    }

    public static Ticket getTicketByClientId(String name) {
        for (Ticket ticket : tickets) {
            if (ticket != null && ticket.getClientId().equals(name)) {
                return ticket;
            }
        }
        return null;
    }

    public static void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}
