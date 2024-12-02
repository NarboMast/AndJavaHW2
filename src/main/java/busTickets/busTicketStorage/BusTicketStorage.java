package busTickets.busTicketStorage;

import busTickets.BusTicket;
import busTickets.BusTicketValidation;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusTicketStorage {
    public ArrayList<BusTicket> busTickets = new ArrayList<>();

    public BusTicketStorage() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.findAndRegisterModules();

            List<BusTicket> loadedTickets = objectMapper.readValue(
                    new File("src//main//java//busTickets//busTicketStorage//busTickets.json"), new TypeReference<List<BusTicket>>() {}
            );

            busTickets.addAll(loadedTickets);
        } catch (IOException e) {
            System.err.println("Failed to load tickets from JSON file: " + e.getMessage());
        }

        for (BusTicket busTicket : busTickets) {
            validateBusTicket(busTicket);
        }
    }

    public static void validateBusTicket(BusTicket busTicket) {
        boolean validTicket = true;
        if (!BusTicketValidation.validateBusTicketStartDate(busTicket.getBusTicketStartDate(), busTicket.getBusTicketType())) {
            validTicket = false;
            BusTicket.startDateViolation++;
        }
        if (!BusTicketValidation.validateBusTicketPrice(busTicket.getBusTicketPrice())) {
            validTicket = false;
            BusTicket.priceViolation++;
        }
        if (!BusTicketValidation.validateBusTicketType(busTicket.getBusTicketType())) {
            validTicket = false;
            BusTicket.ticketTypeViolation++;
        }

        if (validTicket) {
            BusTicket.validBusTickets++;
        }
    }

    @Override
    public String toString() {
        return  "..."
                + "\nTotal: " + busTickets.size()
                + "\nValid: " + BusTicket.validBusTickets
                + "\nMost popular violation: " + BusTicket.maxViolation
                + "\n...";
    }

    public BusTicket getBusTicket(int n) {
        return busTickets.get(n);
    }
}