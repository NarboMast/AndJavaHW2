package busTickets;

import busTickets.busTicketStorage.BusTicketStorage;
import busTickets.busTicketStorage.ViolationStatistics;

import java.time.LocalDate;

public class BusTicketValidation {
    public static boolean validateBusTicketStartDate(LocalDate busTicketStartDate, BusTicketType busTicketType) {
        if (busTicketStartDate == null && (busTicketType == BusTicketType.DAY || busTicketType == BusTicketType.WEEK || busTicketType == BusTicketType.YEAR)) {
            return false;
        }


        return busTicketStartDate == null || !busTicketStartDate.isAfter(LocalDate.now());
    }

    public static boolean validateBusTicketPrice(Integer price){
        if(price == null || price <= 0){
            return false;
        }
        return price % 2 == 0;
    }

    public static boolean validateBusTicketType(BusTicketType busTicketType) {
        return busTicketType == BusTicketType.DAY || busTicketType == BusTicketType.WEEK || busTicketType == BusTicketType.MONTH || busTicketType == BusTicketType.YEAR;
    }

    //
    public static void validateBusTicket(BusTicket busTicket, ViolationStatistics violationStatistics) {
        boolean validTicket = true;
        if (!BusTicketValidation.validateBusTicketStartDate(busTicket.getBusTicketStartDate(), busTicket.getBusTicketType())) {
            validTicket = false;
            violationStatistics.incrementStartDateViolation();
        }
        if (!BusTicketValidation.validateBusTicketPrice(busTicket.getBusTicketPrice())) {
            validTicket = false;
            violationStatistics.incrementPriceViolation();
        }
        if (!BusTicketValidation.validateBusTicketType(busTicket.getBusTicketType())) {
            validTicket = false;
            violationStatistics.incrementTicketTypeViolation();
        }

        if (validTicket) {
            violationStatistics.incrementValidBusTickets();
        }
    }
}
