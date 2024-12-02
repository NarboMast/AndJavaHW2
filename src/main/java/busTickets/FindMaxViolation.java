package busTickets;

public class FindMaxViolation {
    public static String findMaxViolation(int a, int b, int c) {
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
}
