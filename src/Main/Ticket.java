package Main;

import Enums.StadiumSector;
import Enums.PromoStatus;

import java.sql.Timestamp;

public class Ticket  extends Indexable implements Printable, Validation{
    private String id;
    private final String concertHall;
    private final Short eventCode;
    private Timestamp eventTime;
    private final PromoStatus PROMO;
    private StadiumSector stadiumSector;
    private final Float maxWeight;
    private static Timestamp ticketCreationTime;

    public Ticket
            (String id,
            String concertHall,
            Short eventCode,
            Timestamp eventTime,
            PromoStatus promo,
            StadiumSector stadiumSector,
            Float weight) {
        idValid(id);
        concertHallValid(concertHall);
        eventCodeValid(eventCode);

        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
        this.PROMO = promo;
        this.stadiumSector = stadiumSector;
        this.maxWeight = weight;
        ticketCreationTime = new Timestamp(System.currentTimeMillis());
    }


    public Ticket(String concertHall,
                  Short eventCode,
                  Timestamp eventTime) {
        concertHallValid(concertHall);
        eventCodeValid(eventCode);

        this.id = null;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
        this.PROMO = null;
        this.stadiumSector = null;
        this.maxWeight = null;
        ticketCreationTime = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String print() {
        return  "Ticket ID: " + id
                + "\nConcert Hall: " + concertHall
                + "\nEvent Code: " + eventCode
                + "\nEvent Time: " + eventTime
                + "\nPromo: " + PROMO
                + "\nStadium sector: " + stadiumSector
                + "\nMax allowed backpack weight: " + maxWeight
                + "\nTicket creation time: " + ticketCreationTime +"\n";
    }

    public String shared(String id){
        return "Ticket: " + id + " is shared via phone";
    }

    public String shared(String id, boolean viaEmail){
        return "Ticket: " + id + " is shared via phone and email";
    }

    public void setEventTime(Timestamp eventTime) {
        this.eventTime = eventTime;
    }
    public void setStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
    }
}
