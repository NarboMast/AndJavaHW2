package ticketService;

import enums.*;

import java.sql.Timestamp;

public class Ticket extends Indexable implements Printable {
    private String id;
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

        this.id = id;
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

        this.id = null;
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

    public String getClientId(){
        return clientId;
    }

    public String share(){
        if(sharedType == null){
            return "Ticket " + getId() + " is not shared";
        }
        return sharedType.share();
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
