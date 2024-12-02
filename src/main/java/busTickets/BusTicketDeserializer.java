package busTickets;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class BusTicketDeserializer {
    @JsonCreator
    public static BusTicket fromJson(
            @JsonProperty("ticketClass") BusTicketClass busTicketClass,
            @JsonProperty("ticketType") BusTicketType busTicketType,
            @JsonProperty("startDate") LocalDate busTicketStartDate,
            @JsonProperty("price") Integer busTicketPrice
    ) {
        return new BusTicket(busTicketClass, busTicketType, busTicketStartDate, busTicketPrice);
    }
}