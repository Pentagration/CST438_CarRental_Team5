package carRental.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="reservation")
public class CarReservation {

  @Id
  private String email;
  private String pickupLocation;
  private String pickupDate;
  private String returnLocation;
  private String returnDate;
  private long carID;
  public CarReservation(){}

  public CarReservation(String email,
      String pickupLocation, String pickupDate,
      String returnLocation, String returnDate, long carID){
    super();
    this.email = email;
    this.pickupLocation = pickupLocation;
    this.pickupDate = pickupDate;
    this.returnLocation = returnLocation;
    this.returnDate = returnDate;
    this.carID = carID;
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

  public long getCarID() {
    return carID;
  }

  public void setCarID(long carID) {
    this.carID = carID;
  }

  @Override
  public String toString() {
    return "CarReservation [email=" + email +
        ", pickupLocation=" + pickupLocation + ", pickupDate=" + pickupDate +
        ", returnLocation=" + returnLocation + ", returnDate=" + returnDate +
         "]";
  }
}
