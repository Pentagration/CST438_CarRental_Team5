package carRental.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="car")
public class CarInfo {

    @Id
    @GeneratedValue
    private long carID;
    @NotEmpty
    private String type;
    private int price;
    private boolean available;

    public CarInfo(){}

    public CarInfo(String type, int price, boolean available){
        super();
        this.type = type;
        this.price = price;
        this.available = available;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPrice(String car){
        if(car.equals("SUV"))
            price = 150;
        else if(car.equals("Fullsize"))
            price = 125;
        else if(car.equals("Economy"))
            price = 110;
        else if(car.equals("Compact"))
            price = 5;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

    @Override
    public String toString() {
        return "CarReservation [carId=" + carID +
                ", type=" + type +
                ", price=" + price + "]";
    }
}
