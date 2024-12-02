package busTickets;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class BusTicket {
    public static int validBusTickets = 0;
    public static int startDateViolation;
    public static int priceViolation;
    public static int ticketTypeViolation;
    public static final String maxViolation = FindMaxViolation.findMaxViolation(startDateViolation, priceViolation, ticketTypeViolation);

    private int busTicketId;
    private int userId;
    private BusTicketClass busTicketClass;
    private BusTicketType busTicketType;
    private LocalDate busTicketStartDate;
    private Integer busTicketPrice;
    private LocalDate creationDate;

    // Default constructor required for Jackson
    public BusTicket() {}
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

    @JsonProperty("ticketClass")
    public BusTicketClass getBusTicketClass() {
        return busTicketClass;
    }
    @JsonProperty("ticketClass")
    public void setBusTicketClass(BusTicketClass busTicketClass) {
        this.busTicketClass = busTicketClass;
    }

    @JsonProperty("ticketType")
    public BusTicketType getBusTicketType() {
        return busTicketType;
    }
    @JsonProperty("ticketType")
    public void setBusTicketType(BusTicketType busTicketType) {
        this.busTicketType = busTicketType;
    }

    @JsonProperty("startDate")
    public LocalDate getBusTicketStartDate() {
        return busTicketStartDate;
    }
    @JsonProperty("startDate")
    public void setBusTicketStartDate(LocalDate busTicketStartDate) {
        this.busTicketStartDate = busTicketStartDate;
    }

    @JsonProperty("price")
    public Integer getBusTicketPrice() {
        return busTicketPrice;
    }
    @JsonProperty("price")
    public void setBusTicketPrice(Integer busTicketPrice) {
        this.busTicketPrice = busTicketPrice;
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
