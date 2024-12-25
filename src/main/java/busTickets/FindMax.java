package busTickets;

public class FindMax {
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
