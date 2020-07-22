package carRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="reservation")
public class CarReservation {

  @Id
  private long customerID;
  private long carID;
  @NotEmpty
  private String fName;
  @NotEmpty
  private String lName;
  private String email;
  private String pickupLocation;
  private String pickupDate;
  private String returnLocation;
  private String returnDate;
  private String type;

  public CarReservation(){}

  public CarReservation(long customerID, long carID, String fName, String lName, String email,
      String pickupLocation, String pickupDate,
      String returnLocation, String returnDate, String type){
    super();
    this.customerID = customerID;
    this.carID = carID;
    this.fName = fName;
    this.lName = lName;
    this.email = email;
    this.pickupLocation = pickupLocation;
    this.pickupDate = pickupDate;
    this.returnLocation = returnLocation;
    this.returnDate = returnDate;
    this.type = type;
  }

  public long getCustomerID() {
    return customerID;
  }

  public void setCustomerID(long customerID) {
    this.customerID = customerID;
  }

  public long getCarID() {
    return carID;
  }

  public void setCarID(long carID) {
    this.carID = carID;
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "CarReservation [customerId=" + customerID + ", carID=" + carID +
        ", fName=" + fName + ", lName=" + lName + ", email=" + email +
        ", pickupLocation=" + pickupLocation + ", pickupDate=" + pickupDate +
        ", returnLocation=" + returnLocation + ", returnDate=" + returnDate +
        ", type=" + type + "]";
  }
}
