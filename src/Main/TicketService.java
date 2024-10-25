package Main;

import Enums.StadiumSector;
import Enums.PromoStatus;

import java.sql.Timestamp;

public class TicketService{
    public static void main(String[] args) {
        Ticket ticketFull = new Ticket(
                "dd12",
                "1234567890",
                (short)123,
                Timestamp.valueOf("2024-12-20 20:00:00"),
                PromoStatus.YES,
                StadiumSector.A,
                10.999f
        );
        System.out.println(ticketFull.toString());


        Ticket ticketEmpty = new Ticket(
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
        System.out.println(ticketEmpty.toString());


        Ticket ticketLimited = new Ticket(
                "1234567890",
                (short)123,
                Timestamp.valueOf("2024-6-1 18:30:00")
        );

        System.out.println(ticketLimited.toString());
    }
}
