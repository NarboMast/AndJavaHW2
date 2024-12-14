package users;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "\"User\"")
public class User {
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    private LocalDate creationDate; //"YYYY-MM-DD" format

    //Empty constructor for hibernate
    public User() {}

    public User(String name) {
        this.name = name;
        this.creationDate = LocalDate.now();
    }

    public User(int id, String name, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String printRole(){
        return "I am just a user";
    }
    @Override
    public String toString(){
        return id + " " + name + " " + creationDate;
    }
}
