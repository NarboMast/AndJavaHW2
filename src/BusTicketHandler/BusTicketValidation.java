package BusTicketHandler;

import java.time.LocalDate;

public class BusTicketValidation {

    public static boolean validateBusTicketStartDate(LocalDate busTicketStartDate, BusTicketType busTicketType) {
        if (busTicketStartDate == null && (busTicketType == BusTicketType.DAY || busTicketType == BusTicketType.WEEK || busTicketType == BusTicketType.MONTH || busTicketType == BusTicketType.YEAR)) {
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
        return true;
    }
    public static boolean validateBusTicketType(BusTicketType busTicketType) {
        if(busTicketType == null){
            BusTicket.TicketTypeViolation++;
            return false;
        }
        return true;
    }
}
