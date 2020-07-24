package carRental.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="reservation")
public class CarCustomer {

    @Id
    @NotEmpty
    @Column(name = "email")
    private String email;
    private String fName;
    private String lName;

    @ManyToOne
    @JoinColumn(name = "email")
    CarReservation carReservation;

    public CarCustomer(){}

    public CarCustomer(String email, String fName, String lName){
        super();
        this.email = email;
        this.fName = fName;
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "CarCustomer [email=" + email +
                ", fName=" + fName + ", lName=" + lName +
                "]";
    }
}
