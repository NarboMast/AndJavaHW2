package busTickets.busTicketStorage;

import busTickets.BusTicket;
import busTickets.BusTicketClass;
import busTickets.BusTicketType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JsonMethods {
    public static void fileExists(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            throw new IOException("File does not exist or is not readable: " + filePath);
        }
    }

    public static List<BusTicket> deserialize(String filePath){
        List<BusTicket> loadedTickets = new ArrayList<>();
        try{
            fileExists(filePath);

            Object obj = new JSONParser().parse(new FileReader(filePath));
            JSONArray jsonArray = (JSONArray) obj;

            for(Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;

                // Handle null parsing for TicketType and TicketClass
                String ticketClass = (String) jsonObject.get("ticketClass");
                String ticketType = (String) jsonObject.get("ticketType");

                BusTicketClass busTicketClass = null;
                BusTicketType busTicketType = null;

                if(ticketClass != null){
                    busTicketClass = BusTicketClass.valueOf(ticketClass);
                }
                if(ticketType != null){
                    busTicketType = BusTicketType.valueOf(ticketType);
                }

                // Handle null and empty values for StartDate
                String startDateStr = (String) jsonObject.get("startDate");
                LocalDate startDate = null;
                if (startDateStr != null && !startDateStr.isEmpty()) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    startDate = LocalDate.parse(startDateStr, formatter);
                }

                // Handle null values for price
                Number priceNumber = (Number) jsonObject.get("price");
                Integer price = null;
                if (priceNumber != null) {
                    price = priceNumber.intValue();
                }

                BusTicket busTicket = new BusTicket(
                        busTicketClass,
                        busTicketType,
                        startDate,
                        price);

                loadedTickets.add(busTicket);
            }
        } catch (IOException | ParseException e){
            System.err.println("Failed to load tickets from JSON file: " + e.getMessage());
        }
        return loadedTickets;
    }
}
