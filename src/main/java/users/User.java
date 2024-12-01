package users;

import java.time.LocalDate;

public class User {
    private int id;
    private final String name;
    private final LocalDate creationDate; //"YYYY-MM-DD" format

    public User(String name) {
        this.name = name;
        this.creationDate = LocalDate.now();
    }

    public User(int id, String name, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public long getId() {
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

    public String toPrint(){
        return id + " " + name + " " + creationDate;
    }
}
