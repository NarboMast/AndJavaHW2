package users;

import ticketService.Ticket;
import ticketService.TicketStorage;

public class Admin extends User {
    private Role role;
    private String adminId;

    public Admin(User user, String adminId) {
        super(user.getName());
        this.adminId = adminId;
        this.role = Role.ADMIN;
    }

    public void checkTicketById(String id) {
        Ticket ticket = TicketStorage.getTicketById(id);
        if(ticket == null) {
            System.out.println("Admin " + adminId + ": Fake ticket or not found: " + id);
        } else {
            System.out.println("Admin" + adminId + ": Welcome, " + ticket.getClientId());
        }
    }

    public void checkTicketByClientId(String clietnId){
        Ticket ticket = TicketStorage.getTicketByClientId(clietnId);
        if(ticket == null) {
            System.out.println("Admin" + adminId + ": Fake ticket or not found");
        } else {
            System.out.println("Admin" + adminId + ": Welcome, " + clietnId);
        }
    }

    @Override
    public String printRole() {
        return "I am an admin";
    }
}
