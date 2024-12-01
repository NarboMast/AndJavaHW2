package db;

import busTicketHandler.BusTicket;
import busTicketHandler.BusTicketType;
import users.User;

import java.sql.*;

public class DAO {
    private final String url;
    private final String user;
    private final String password;

    public DAO(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    //I just needed this method to clean up all data after all my executions
    public void clearAllData() {
        String deleteTicketsSql = "DELETE FROM Ticket";
        String resetTicketSequenceSql = "ALTER SEQUENCE public.ticket_id_seq RESTART WITH 1";

        String deleteUsersSql = "DELETE FROM \"User\"";
        String resetUserSequenceSql = "ALTER SEQUENCE \"User_id_seq\" RESTART WITH 1";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(deleteTicketsSql);
            System.out.println("All data from Ticket table cleared.");

            stmt.executeUpdate(resetTicketSequenceSql);
            System.out.println("Primary key sequence for Ticket table reset.");

            stmt.executeUpdate(deleteUsersSql);
            System.out.println("All data from \"User\" table cleared.");

            stmt.executeUpdate(resetUserSequenceSql);
            System.out.println("Primary key sequence for \"User\" table reset.");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Exception in clearAllData");
        }
    }

    public void addUser(User user) {
        String sql = "INSERT INTO \"User\" (name, creation_date) VALUES (?, ?) RETURNING id";

        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setDate(2, Date.valueOf(user.getCreationDate()));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user.setId(rs.getInt("id"));
                    System.out.println("User " + user.getName() + " added. With id " + user.getId());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Exception in addUser");
        }
    }

    public void addTicket(BusTicket busTicket, User user) {
        String sql = "INSERT INTO public.ticket (user_id, ticket_type, creation_date) VALUES (?, CAST(? AS ticket_type), ?) RETURNING id";

        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, user.getId());
            stmt.setString(2, busTicket.getBusTicketType().name());
            stmt.setDate(3, Date.valueOf(busTicket.getCreationDate()));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    busTicket.setBusTicketId(rs.getInt("id"));
                    System.out.println("Ticket added under id: " + busTicket.getBusTicketId());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Exception in addTicket");
        }
    }

    public BusTicket fetchTicketById(int id) {
        String sql = "SELECT * FROM Ticket WHERE id = ?";
        BusTicket busTicket = null;

        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()) {
                    int busTicketId = rs.getInt("id");
                    int userId = rs.getInt("user_id");
                    String ticketType = rs.getString("ticket_type");
                    Date creationDate = rs.getDate("creation_date");

                    return busTicket = new BusTicket(busTicketId, userId, BusTicketType.valueOf(ticketType), creationDate.toLocalDate());
                } else {
                    System.out.println("Ticket with ID " + id + " not found.");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Exception in fetchTicketById");
        }
        return busTicket;
    }

    public BusTicket fetchTicketByUserId(int id) {
        String sql = "SELECT * FROM Ticket WHERE user_id = ?";
        BusTicket busTicket = null;

        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()) {
                    int busTicketId = rs.getInt("id");
                    int userId = rs.getInt("user_id");
                    String ticketType = rs.getString("ticket_type");
                    Date creationDate = rs.getDate("creation_date");

                    return busTicket = new BusTicket(busTicketId, userId, BusTicketType.valueOf(ticketType), creationDate.toLocalDate());
                } else {
                    System.out.println("Ticket with ID " + id + " not found.");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Exception in fetchTicketById");
        }
        return busTicket;
    }

    public User fetchUserById(int id) {
        String sql = "SELECT * FROM \"User\" WHERE id = ?";
        User user = null;

        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()) {
                    int userId = rs.getInt("id");
                    String userName = rs.getString("name");
                    Date creationDate = rs.getDate("creation_date");

                    return user = new User(userId, userName, creationDate.toLocalDate());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Exception in fetchUserById");
        }
        return user;
    }

    public void deleteUserAndTicketsById(int userId) {
        String deleteTicketsSql = "DELETE FROM Ticket WHERE user_id = ?";
        String deleteUserSql = "DELETE FROM \"User\" WHERE id = ?";

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement deleteTicketsStmt = conn.prepareStatement(deleteTicketsSql)) {
                deleteTicketsStmt.setInt(1, userId);
                int ticketsDeleted = deleteTicketsStmt.executeUpdate();
                System.out.println("Deleted " + ticketsDeleted + " tickets with user_id: " + userId);
            }

            try (PreparedStatement deleteUserStmt = conn.prepareStatement(deleteUserSql)) {
                deleteUserStmt.setInt(1, userId);
                int usersDeleted = deleteUserStmt.executeUpdate();

                if (usersDeleted > 0) {
                    System.out.println("User with ID " + userId + " deleted successfully.");
                    conn.commit();
                } else {
                    System.out.println("User with ID " + userId + " not found");
                    conn.rollback();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Exception in deleteUserAndTicketsById");
        }
    }
}
