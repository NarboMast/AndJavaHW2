package busTickets;

import java.time.LocalDate;

public class BusTicket {
    private int busTicketId;
    private int userId;
    private BusTicketClass busTicketClass;
    private BusTicketType busTicketType;
    private LocalDate busTicketStartDate;
    private Integer busTicketPrice;
    private LocalDate creationDate;

    //Constructor for JSON file formatted tickets
    public BusTicket(
            BusTicketClass busTicketClass,
            BusTicketType busTicketType,
            LocalDate busTicketStartDate,
            Integer busTicketPrice
    ) {
        this.busTicketClass = busTicketClass;
        this.busTicketType = busTicketType;
        this.busTicketStartDate = busTicketStartDate;
        this.busTicketPrice = busTicketPrice;
    }

    //Constructor for DAO (database) tickets
    public BusTicket(
            int busTicketId,
            int userId,
            BusTicketType busTicketType,
            LocalDate creationDate
    ){
        this.busTicketId = busTicketId;
        this.userId = userId;
        this.busTicketType = busTicketType;
        this.creationDate = creationDate;
    }

    public BusTicketType getBusTicketType() {
        return busTicketType;
    }

    public LocalDate getBusTicketStartDate() {
        return busTicketStartDate;
    }

    public Integer getBusTicketPrice() {
        return busTicketPrice;
    }

    public String getCreationDate() {
        return creationDate.toString();
    }

    public void setBusTicketId(int busTicketId) {
        this.busTicketId = busTicketId;
    }

    public int getBusTicketId() {
        return busTicketId;
    }

    @Override
    public String toString(){
        return busTicketId + " " + userId + " " + busTicketType + " " + creationDate;
    }
}
