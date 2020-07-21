package carRental.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class CarReservation {

  @Id
  private long customerID;
  private long carID;
  private String pickupDate;
  private String returnDate;
  private String pickupLocation;
  private String returnLocation;

  public CarReservation(){
    this(0, 0, "pickupDate", "returnDate", "pickupLocation", "returnLocation");
  }

  public CarReservation(long customerID, long carID, String pickupDate, String returnDate,
      String pickupLocation, String returnLocation){
    super();
    this.customerID = customerID;
    this.carID = carID;
    this.pickupDate = pickupDate;
    this.returnDate = returnDate;
    this.pickupLocation = pickupLocation;
    this.returnLocation = returnLocation;
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

  public String getPickupDate() {
    return pickupDate;
  }

  public void setPickupDate(String pickupDate) {
    this.pickupDate = pickupDate;
  }

  public String getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(String returnDate) {
    this.returnDate = returnDate;
  }

  public String getPickupLocation() {
    return pickupLocation;
  }

  public void setPickupLocation(String pickupLocation) {
    this.pickupLocation = pickupLocation;
  }

  public String getReturnLocation() {
    return returnLocation;
  }

  public void setReturnLocation(String returnLocation) {
    this.returnLocation = returnLocation;
  }

  @Override
  public String toString() {
    return "CarReservation [customerId=" + customerID + ", carID=" + carID +
        ", pickupDate=" + pickupDate + ", returnDate=" + returnDate +
        ", pickupLocation=" + pickupLocation + ", returnLocation=" + returnLocation + "]";
  }
}
