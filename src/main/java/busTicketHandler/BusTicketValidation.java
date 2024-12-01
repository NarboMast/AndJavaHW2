package busTicketHandler;

import java.time.LocalDate;

public class BusTicketValidation {

    public static boolean validateBusTicketStartDate(LocalDate busTicketStartDate, BusTicketType busTicketType) {
        if (busTicketStartDate == null && (busTicketType == BusTicketType.DAY || busTicketType == BusTicketType.WEEK || busTicketType == BusTicketType.MONTH || busTicketType == BusTicketType.YEAR)) {
            BusTicket.startDateViolation++;
            return false;
        }

        if (busTicketStartDate != null && busTicketStartDate.isAfter(LocalDate.now())) {
            BusTicket.startDateViolation++;
            return false;
        }

        return true;
    }
    public static boolean validateBusTicketPrice(Integer price){
        if(price == null || price <= 0){
            BusTicket.priceViolation++;
            return false;
        }
        if(price % 2 != 0){
            BusTicket.priceViolation++;
            return false;
        }
        return true;
    }
    public static boolean validateBusTicketType(BusTicketType busTicketType) {
        if(busTicketType == null){
            BusTicket.ticketTypeViolation++;
            return false;
        }
        return true;
    }
}
