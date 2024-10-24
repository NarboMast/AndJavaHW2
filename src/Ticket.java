import java.sql.Timestamp;

public class Ticket {
    private final String ID;
    private final String concertHall;
    private final Short eventCode;
    private final Timestamp eventTime;
    private final Boolean PROMO;
    private final Character stadiumSector;
    private final Float maxWeight;
    private static Timestamp ticketCreationTime;

    public Ticket
            (String id,
            String concertHall,
            Short eventCode,
            Timestamp eventTime,
            Boolean promo,
            Character stadiumSector,
            Float weight)
    {
        idValid(id);
        concertHallValid(concertHall);
        eventCodeValid(eventCode);
        stadiumSectorValid(stadiumSector);

        this.ID = id;
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
                  Timestamp eventTime)
    {
        concertHallValid(concertHall);
        eventCodeValid(eventCode);

        this.ID = null;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
        this.PROMO = null;
        this.stadiumSector = null;
        this.maxWeight = null;
        ticketCreationTime = new Timestamp(System.currentTimeMillis());
    }

    private void idValid(String id){
        if(id != null && id.length()!= 4){
            System.out.println("ID of the ticket must be exactly 4 digits or/and chars");
            System.exit(-1);
        }
    }

    private void concertHallValid(String concertHall){
        if(concertHall != null && concertHall.length() > 10){
            System.out.println("Concert Hall cannot be longer than 10 digits");
            System.exit(-1);
        }
    }

    private void eventCodeValid(Short eventCode){
        if (eventCode != null && (eventCode < 100 || eventCode > 999)){
            System.out.println("Event code must be exactly 3 digits");
            System.exit(-1);
        }
    }

    private void stadiumSectorValid(Character stadiumSector){
        if(stadiumSector != null && (stadiumSector < 65 || stadiumSector > 67)){
            System.out.println("Stadium sector must be A, B or C");
            System.exit(-1);
        }
    }

    @Override
    public String toString() {
        return  "Ticket ID: " + ID
                + "\nConcert Hall: " + concertHall
                + "\nEvent Code: " + eventCode
                + "\nEvent Time: " + eventTime
                + "\nPromo: " + PROMO
                + "\nStadium sector: " + stadiumSector
                + "\nMax allowed backpack weight: " + maxWeight
                + "\nTicket creation time: " + ticketCreationTime +"\n";
    }
}
