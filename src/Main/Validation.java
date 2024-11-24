package Main;

public class Validation {
    public static void validateId(String id){
        if (id == null || id.length() != 4) {
            System.out.println("ID of the ticket must be exactly 4 characters.");
            throw new ValidationException("Invalid ID: " + id);
        }
    }

    public static void concertHallValid(String concertHall){
        if(concertHall != null && concertHall.length() > 10){
            System.out.println("Concert Hall cannot be longer than 10 digits");
            throw new ValidationException("Invalid Concert Hall: " + concertHall);
        }
    }

    public static void eventCodeValid(Short eventCode){
        if (eventCode != null && (eventCode < 100 || eventCode > 999)){
            System.out.println("Event code must be exactly 3 digits");
            throw new ValidationException("Invalid Event Code: " + eventCode);
        }
    }
}
