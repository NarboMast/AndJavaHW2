package busTicketHandler;

import java.time.LocalDate;

public class BusTicket {
    public static int validBusTickets = 0;
    public static int startDateViolation;
    public static int priceViolation;
    public static int TicketTypeViolation;
    public static final String maxViolation = max(startDateViolation, priceViolation, TicketTypeViolation);
    private BusTicketClass busTicketClass;
    private BusTicketType busTicketType;
    private LocalDate busTicketStartDate;
    private Integer busTicketPrice;

    public BusTicket(
            BusTicketClass busTicketClass,
            BusTicketType busTicketType,
            LocalDate busTicketStartDate,
            Integer busTicketPrice) {
        boolean validTicket = true;
        if(!BusTicketValidation.validateBusTicketStartDate(busTicketStartDate, busTicketType)){
            validTicket = false;
        }
        if(!BusTicketValidation.validateBusTicketPrice(busTicketPrice)){
            validTicket = false;
        }
        if(!BusTicketValidation.validateBusTicketType(busTicketType)){
            validTicket = false;
        }

        this.busTicketClass = busTicketClass;
        this.busTicketType = busTicketType;
        this.busTicketStartDate = busTicketStartDate;
        this.busTicketPrice = busTicketPrice;

        if(validTicket){
            validBusTickets++;
        }
    }

    private static String max(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        if(a == max){
            return "Start date";
        } else if(b == max){
            return "Price";
        } else {
            return "Ticket type";
        }
    }
}
