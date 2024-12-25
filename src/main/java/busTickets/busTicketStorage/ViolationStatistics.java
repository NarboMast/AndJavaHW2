package busTickets.busTicketStorage;

import busTickets.FindMaxViolation;

public class ViolationStatistics {
    private int startDateViolation = 0;
    private int priceViolation = 0;
    private int ticketTypeViolation = 0;
    private int validBusTickets = 0;
    private String maxViolation = FindMaxViolation.findMaxViolation(startDateViolation, priceViolation, ticketTypeViolation);

    public void incrementStartDateViolation() {
        startDateViolation++;
    }

    public void incrementPriceViolation() {
        priceViolation++;
    }

    public void incrementTicketTypeViolation() {
        ticketTypeViolation++;
    }

    public void incrementValidBusTickets() {
        validBusTickets++;
    }

    //Getters
    public int getStartDateViolation() {
        return startDateViolation;
    }

    public int getPriceViolation() {
        return priceViolation;
    }

    public int getTicketTypeViolation() {
        return ticketTypeViolation;
    }

    public int getValidBusTickets() {
        return validBusTickets;
    }

    public String getMaxViolation() {
        return maxViolation;
    }
}