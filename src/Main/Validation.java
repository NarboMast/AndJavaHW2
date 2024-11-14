package Main;

public interface Validation {
    default void idValid(String id){
        if(id != null && id.length()!= 4){
            System.out.println("ID of the ticket must be exactly 4 digits or/and chars");
            System.exit(-1);
        }
    }

    default void concertHallValid(String concertHall){
        if(concertHall != null && concertHall.length() > 10){
            System.out.println("Concert Hall cannot be longer than 10 digits");
            System.exit(-1);
        }
    }

    default void eventCodeValid(Short eventCode){
        if (eventCode != null && (eventCode < 100 || eventCode > 999)){
            System.out.println("Event code must be exactly 3 digits");
            System.exit(-1);
        }
    }
}
