package busTickets.busTicketStorage;

import busTickets.BusTicket;
import busTickets.BusTicketValidation;

import java.util.ArrayList;

public class BusTicketStorage {
    public ViolationStatistics violationStatistics;
    public ArrayList<BusTicket> busTickets;

    public BusTicketStorage(String filePath) {
        violationStatistics = new ViolationStatistics();
        busTickets = new ArrayList<>();

        busTickets.addAll(JsonMethods.deserialize(filePath));

        for (BusTicket busTicket : busTickets) {
            BusTicketValidation.validateBusTicket(busTicket, violationStatistics);
        }
    }


    @Override
    public String toString() {
        return  "..."
                + "\nTotal: " + busTickets.size()
                + "\nValid: " + violationStatistics.getValidBusTickets()
                + "\nMost popular violation: " + violationStatistics.getMaxViolation()
                + "\n...";
    }

    public BusTicket getBusTicket(int n) {
        return busTickets.get(n);
    }
}