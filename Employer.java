package beans;

import jakarta.persistence.*;

@Entity
@Table(name = "employers")
public class Employer {

    @Id
    @Column(name = "employer_id")
    private String employerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // Constructors, Getters, Setters
    public Employer() {}

    public Employer(String employerId, String name, String email, String password) {
        this.employerId = employerId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // getters and setters

    public String getEmployerId() {
        return employerId;
    }

    public void setEmployerId(String employerId) {
        this.employerId = employerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "employerId='" + employerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

