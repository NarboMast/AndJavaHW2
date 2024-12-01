package busTicketHandler;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Date;

public class BusTicket {
    public static int validBusTickets = 0;
    public static int startDateViolation;
    public static int priceViolation;
    public static int ticketTypeViolation;
    public static final String maxViolation = max(startDateViolation, priceViolation, ticketTypeViolation);

    private int busTicketId;
    private int userId;
    private BusTicketClass busTicketClass;
    private BusTicketType busTicketType;
    private LocalDate busTicketStartDate;
    private Integer busTicketPrice;
    private LocalDate creationDate;

    // Default constructor required for Jackson
    public BusTicket() {}

    // Constructor for Jackson and validation
    @JsonCreator
    public BusTicket(
            @JsonProperty("ticketClass") BusTicketClass busTicketClass,
            @JsonProperty("ticketType") BusTicketType busTicketType,
            @JsonProperty("startDate") LocalDate busTicketStartDate,
            @JsonProperty("price") Integer busTicketPrice
    ) {
        this.busTicketClass = busTicketClass;
        this.busTicketType = busTicketType;
        this.busTicketStartDate = busTicketStartDate;
        this.busTicketPrice = busTicketPrice;
        this.creationDate = LocalDate.now();

        // Validation logic
        boolean validTicket = true;
        if (!BusTicketValidation.validateBusTicketStartDate(busTicketStartDate, busTicketType)) {
            validTicket = false;
            startDateViolation++;
        }
        if (!BusTicketValidation.validateBusTicketPrice(busTicketPrice)) {
            validTicket = false;
            priceViolation++;
        }
        if (!BusTicketValidation.validateBusTicketType(busTicketType)) {
            validTicket = false;
            ticketTypeViolation++;
        }

        if (validTicket) {
            validBusTickets++;
        }
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

    private static String max(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        if (a == max) {
            return "Start date";
        } else if (b == max) {
            return "Price";
        } else {
            return "Ticket type";
        }
    }

    public BusTicketType getBusTicketType() {
        return busTicketType;
    }

    public String getCreationDate() {
        return creationDate != null ? creationDate.toString() : null;
    }

    public void setBusTicketId(int busTicketId) {
        this.busTicketId = busTicketId;
    }

    public int getBusTicketId() {
        return busTicketId;
    }

    public String toPrint(){
        return busTicketId + " " + userId + " " + busTicketType + " " + creationDate;
    }
}
