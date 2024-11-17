package Main;

import Enums.*;

import java.sql.Timestamp;

public class Ticket extends Indexable implements Printable, Validation, SharedVia{
    private String id;
    private final String concertHall;
    private final Short eventCode;
    private Timestamp eventTime;
    private final PromoStatus PROMO;
    private StadiumSector stadiumSector;
    private final Float maxWeight;
    private static Timestamp ticketCreationTime;
    private SharedViaEnum sharedViaEnum;

    public Ticket
            (String id,
            String concertHall,
            Short eventCode,
            Timestamp eventTime,
            PromoStatus promo,
            StadiumSector stadiumSector,
            Float weight,
            SharedViaEnum sharedViaEnum) {
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
        this.sharedViaEnum = sharedViaEnum;
    }


    public Ticket(String concertHall,
                  Short eventCode,
                  Timestamp eventTime,
                  SharedViaEnum sharedViaEnum) {
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
        this.sharedViaEnum = sharedViaEnum;
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
                + "\nTicket creation time: " + ticketCreationTime;
    }

    @Override
    public String shared(Ticket ticket){
        if(getSharedViaEnum() == null){
            return "Ticket is not shared";
        }

        return switch (getSharedViaEnum()) {
            case PHONE -> "Ticket is shared via phone";
            case PHONE_EMAIL -> "Ticket is shared via phone and email";
        };
    }

    public SharedViaEnum getSharedViaEnum(){
        return sharedViaEnum;
    }

    public void setEventTime(Timestamp eventTime) {
        this.eventTime = eventTime;
    }
    public void setStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
    }
}
