package busTicketHandler.busTicketStorage;

import busTicketHandler.BusTicket;
import busTicketHandler.BusTicketClass;
import busTicketHandler.BusTicketType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BusTicketStorage {
    public ArrayList<BusTicket> busTickets = new ArrayList<>();

    public BusTicketStorage() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.findAndRegisterModules(); // Register modules for custom deserialization (e.g., LocalDate)

            List<BusTicket> loadedTickets = objectMapper.readValue(
                    new File("src//main//java//busTicketHandler//busTicketStorage//busTickets.json"), new TypeReference<List<BusTicket>>() {}
            );

            busTickets.addAll(loadedTickets);
        } catch (IOException e) {
            System.err.println("Failed to load tickets from JSON file: " + e.getMessage());
        }
    }

    public String toPrint() {
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