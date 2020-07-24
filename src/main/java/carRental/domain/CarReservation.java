package carRental.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="reservation")
public class CarReservation {

  @Id
  @GeneratedValue
  private long customerID;
  @NotEmpty
  @Column(name = "email")
  private String email;
  private String pickupLocation;
  private String pickupDate;
  private String returnLocation;
  private String returnDate;

  @ManyToOne
  @JoinColumn(name = "email")
  CarCustomer carCustomer;

  public CarReservation(){}

  public CarReservation(long customerID, String email,
      String pickupLocation, String pickupDate,
      String returnLocation, String returnDate){
    super();
    this.customerID = customerID;
    this.email = email;
    this.pickupLocation = pickupLocation;
    this.pickupDate = pickupDate;
    this.returnLocation = returnLocation;
    this.returnDate = returnDate;
  }

  public long getCustomerID() {
    return customerID;
  }

  public void setCustomerID(long customerID) {
    this.customerID = customerID;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPickupLocation() {
    return pickupLocation;
  }

  public void setPickupLocation(String pickupLocation) {
    this.pickupLocation = pickupLocation;
  }

  public String getPickupDate() {
    return pickupDate;
  }

  public void setPickupDate(String pickupDate) {
    this.pickupDate = pickupDate;
  }

  public String getReturnLocation() {
    return returnLocation;
  }

  public void setReturnLocation(String returnLocation) {
    this.returnLocation = returnLocation;
  }

  public String getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(String returnDate) {
    this.returnDate = returnDate;
  }

  @Override
  public String toString() {
    return "CarReservation [customerId=" + customerID +
          ", email=" + email +
        ", pickupLocation=" + pickupLocation + ", pickupDate=" + pickupDate +
        ", returnLocation=" + returnLocation + ", returnDate=" + returnDate +
         "]";
  }
}
