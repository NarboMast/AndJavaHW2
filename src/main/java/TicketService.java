import busTickets.BusTicket;
import busTickets.BusTicketType;
import busTickets.busTicketStorage.BusTicketStorage;
import db.DAO;
import ticketService.Ticket;
import ticketService.TicketStorage;
import users.*;

import java.sql.SQLException;
import java.util.Scanner;

public class TicketService {
    public static void main(String[] args) {
        TicketStorage ticketStorage = new TicketStorage();
        Ticket ticket = ticketStorage.getTicketById("dd01");
        System.out.println(ticket.print());
        System.out.println(ticket.shared());

        User user1 = new User("Narboto");
        Client client = new Client(user1,"CL0000000001");
        System.out.println(client.printRole() + " and i own a ticket under id: " + ticket.getTicketId());

        User user2 = new User("Google");
        Admin admin = new Admin(user2, "AD0000000001");
        System.out.println(admin.printRole());
        admin.checkTicketById(ticket.getTicketId());
        admin.checkTicketByClientId(client.getClientId());

        String JsonFilePath = "src//main//java//busTickets//busTicketStorage//busTickets.json";
        BusTicketStorage busTicketStorage = new BusTicketStorage(JsonFilePath);
        System.out.println(busTicketStorage.toString());


        //Task 8
        String url = "jdbc:postgresql://localhost:5432/my_ticket_service_db";
        String user = "postgres";
        Scanner sc = new Scanner(System.in);
        System.out.println("Type password");
        String password = sc.nextLine();
        sc.close();

        DAO dao = new DAO(url,user,password);
        try {
            dao.getConnection();
            System.out.println("Connected successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Exception in getConnection");
        }

        dao.addUser(user1);
        dao.addUser(user2);

        dao.addTicket(BusTicketType.DAY, "2020-12-12", user1);
        dao.addTicket(BusTicketType.WEEK, "2022-12-11", user2);

        BusTicket busTicket2 = dao.fetchTicketById(2);
        if (busTicket2 != null) {
            System.out.println(busTicket2.toString());
        }

        BusTicket busTicket3 = dao.fetchTicketByUserId(1);
        if (busTicket2 != null) {
            System.out.println(busTicket3.toString());
        }

        User user3 = dao.fetchUserById(2);
        if (user3 != null) {
            System.out.println(user3.toPrint());
        }

        dao.deleteUserAndTicketsById(2);

        dao.clearAllData();
    }
}
