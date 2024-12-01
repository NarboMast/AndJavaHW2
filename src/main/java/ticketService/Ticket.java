package ticketService;

import enums.*;
import sharedVia.ValidateSharedType;

import java.sql.Timestamp;

public class Ticket extends Indexable implements Printable {
    private String ticketId;
    private final String concertHall;
    private final Short eventCode;
    private Timestamp eventTime;
    private final PromoStatus PROMO;
    private StadiumSector stadiumSector;
    private final Float maxWeight;
    private static Timestamp ticketCreationTime;
    private final SharedType sharedType;
    private final String clientId;

    public Ticket
            (String id,
            String concertHall,
            Short eventCode,
            Timestamp eventTime,
            PromoStatus promo,
            StadiumSector stadiumSector,
            Float weight,
            SharedType sharedType,
            String clientId) {
        Validation.validateId(id);
        Validation.concertHallValid(concertHall);
        Validation.eventCodeValid(eventCode);

        this.ticketId = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
        this.PROMO = promo;
        this.stadiumSector = stadiumSector;
        this.maxWeight = weight;
        ticketCreationTime = new Timestamp(System.currentTimeMillis());
        this.sharedType = sharedType;
        this.clientId = clientId;
    }


    public Ticket(String concertHall,
                  Short eventCode,
                  Timestamp eventTime,
                  SharedType sharedType,
                  String clientId) {
        Validation.concertHallValid(concertHall);
        Validation.eventCodeValid(eventCode);

        this.ticketId = null;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
        this.PROMO = null;
        this.stadiumSector = null;
        this.maxWeight = null;
        ticketCreationTime = new Timestamp(System.currentTimeMillis());
        this.sharedType = sharedType;
        this.clientId = clientId;
    }

    @Override
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String getTicketId() {
        return ticketId;
    }

    @Override
    public String print() {
        return  "Ticket ID: " + ticketId
                + "\nConcert Hall: " + concertHall
                + "\nEvent Code: " + eventCode
                + "\nEvent Time: " + eventTime
                + "\nPromo: " + PROMO
                + "\nStadium sector: " + stadiumSector
                + "\nMax allowed backpack weight: " + maxWeight
                + "\nTicket creation time: " + ticketCreationTime;
    }

    public String getClientId(){
        return clientId;
    }

    public String shared(){
        return ValidateSharedType.validateSharedType(sharedType, ticketId);
    }

    public SharedType getSharedViaEnum(){
        return sharedType;
    }

    public void setEventTime(Timestamp eventTime) {
        this.eventTime = eventTime;
    }
    public void setStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
    }
}
