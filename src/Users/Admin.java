package Users;

public class Admin implements User {
    @Override
    public String printRole() {
        return "Admin";
    }

    public String checkTicket() {
        return "";
    }
}
