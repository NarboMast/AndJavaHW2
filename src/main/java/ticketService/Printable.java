package ticketService;

public interface Printable {
    default String print() {
        return "print content in console";
    }
}
