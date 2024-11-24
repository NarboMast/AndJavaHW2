package BusTicketHandler;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

public class BusTicketStorage {
    public static ArrayList<BusTicket> busTickets = new ArrayList<BusTicket>();

    public BusTicketStorage() {
        busTickets.add(new BusTicket(BusTicketClass.CLA, BusTicketType.DAY, LocalDate.parse("2025-01-01"), 0));
        busTickets.add(new BusTicket(BusTicketClass.CLA, BusTicketType.DAY, LocalDate.parse("2025-01-01"), 10));
        busTickets.add(new BusTicket(BusTicketClass.CLA, BusTicketType.PRIME, null, 1000));
        busTickets.add(new BusTicket(BusTicketClass.STD, BusTicketType.DAY, LocalDate.parse("2025-01-01"), 0));
        busTickets.add(new BusTicket(BusTicketClass.STD, BusTicketType.WEEK, LocalDate.parse("2020-01-01"), 50));
        busTickets.add(new BusTicket(BusTicketClass.CLA, BusTicketType.YEAR, LocalDate.parse("2020-01-01"), 500));
        busTickets.add(new BusTicket(BusTicketClass.CLA, BusTicketType.MONTH, LocalDate.parse("2020-01-01"), 100));
        busTickets.add(new BusTicket(BusTicketClass.CLA, BusTicketType.DAY, LocalDate.parse("2020-01-01"), 100));
        busTickets.add(new BusTicket(null, BusTicketType.MONTH, LocalDate.parse("2020-01-01"), 100));
        busTickets.add(new BusTicket(BusTicketClass.STD, BusTicketType.MONTH, LocalDate.parse("2020-01-01"), 100));
        busTickets.add(new BusTicket(BusTicketClass.STD, null, LocalDate.parse("2020-01-01"), 1000));
        busTickets.add(new BusTicket(BusTicketClass.STD, BusTicketType.YEAR, null, 100));
        busTickets.add(new BusTicket(BusTicketClass.CLA, BusTicketType.MONTH, LocalDate.parse("2020-01-01"), 99));
        busTickets.add(new BusTicket(BusTicketClass.STD, BusTicketType.PRIME, LocalDate.parse("2020-01-01"), 0));
        busTickets.add(new BusTicket(BusTicketClass.CLA, BusTicketType.YEAR, null, 100));
        busTickets.add(new BusTicket(BusTicketClass.STD, BusTicketType.DAY, LocalDate.parse("2028-01-01"), 100));
        busTickets.add(new BusTicket(BusTicketClass.CLA, BusTicketType.DAY, null, null));
    }

    public String toPrint() {
        return  "..."
                + "\nTotal: " + busTickets.size()
                + "\nValid: " + BusTicket.validBusTickets
                + "\nMost popular violation: " + BusTicket.maxViolation
                + "\n...";
    }
}
