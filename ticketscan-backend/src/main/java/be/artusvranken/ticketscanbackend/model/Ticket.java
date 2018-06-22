package be.artusvranken.ticketscanbackend.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue()
    private Long id;
    private String userId;
    private String firstName, lastName, email;
    private boolean scanned;

    public Ticket() {
        // Do nothing
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getScanned() { return this.scanned; }
    public Boolean isScanned() { return this.scanned; }

    public void setScanned(boolean scanned) { this.scanned = scanned; }
}
