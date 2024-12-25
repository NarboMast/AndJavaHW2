package busTickets;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Ticket")
public class BusTicket {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int busTicketId;
    @Column(name = "user_id")
    private int userId;
    private BusTicketClass busTicketClass;
    @Column(name = "ticket_type")
    private BusTicketType busTicketType;
    private LocalDate busTicketStartDate;
    private Integer busTicketPrice;
    @Column(name = "creation_date")
    private LocalDate creationDate;

    //Empty constructor for hibernate
    public BusTicket(){}

    //Constructor for JSON file formatted tickets
    public BusTicket(
            BusTicketClass busTicketClass,
            BusTicketType busTicketType,
            LocalDate busTicketStartDate,
            Integer busTicketPrice
    ) {
        this.busTicketClass = busTicketClass;
        this.busTicketType = busTicketType;
        this.busTicketStartDate = busTicketStartDate;
        this.busTicketPrice = busTicketPrice;
    }

    //Constructor for DAO (database) tickets
    public BusTicket(
            int busTicketId,
            int userId,
            BusTicketType busTicketType,
            LocalDate creationDate
    ){
        this.busTicketId = busTicketId;
        this.userId = userId;
        this.busTicketType = busTicketType;
        this.creationDate = creationDate;
    }

    public BusTicket(BusTicketType busTicketType, LocalDate creationDate){
        this.busTicketType = busTicketType;
        this.creationDate = creationDate;
    }

    public int getUserId(){
        return userId;
    }

    public LocalDate getCreationDate(){
        return creationDate;
    }

    public BusTicketType getBusTicketType() {
        return busTicketType;
    }

    public LocalDate getBusTicketStartDate() {
        return busTicketStartDate;
    }

    public Integer getBusTicketPrice() {
        return busTicketPrice;
    }

    public int getBusTicketId() {
        return busTicketId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    @Override
    public String toString(){
        return busTicketId + " " + userId + " " + busTicketType + " " + creationDate;
    }
}
