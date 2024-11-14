package Users;

public class Client implements User{
    @Override
    public String printRole() {
        return "Admin";
    }

    public String getTicket() {
        return "";
    }
}
