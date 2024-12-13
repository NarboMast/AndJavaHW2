package busTickets;

public class FindMaxViolation {
    public static String findMaxViolation(int startDateViolation, int priceViolation, int typeViolation) {
        String startDate = "Start date";
        String price = "Price";
        String ticketType = "Ticket type";

        int max = findMax(startDateViolation, priceViolation, typeViolation);

        if (startDateViolation == max) {
            return startDate;
        } else if (priceViolation == max) {
            return price;
        } else {
            return ticketType;
        }
    }

    public static int findMax(int startDateViolation, int priceViolation, int typeViolation) {
        int max = startDateViolation;
        if (priceViolation > max) {
            max = priceViolation;
        }
        if (typeViolation > max) {
            max = typeViolation;
        }
        return max;
    }
}
