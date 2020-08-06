package carRental.service;

import carRental.domain.CarCustomerRepository;
import carRental.domain.CarInfo;
import carRental.domain.CarInfoRepository;
import carRental.domain.CarReservation;
import carRental.domain.CarReservationRepository;
import carRental.domain.NewApiReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarReservationService {

  @Autowired
  private CarReservationRepository carReservationRepository;

  @Autowired
  private CarCustomerRepository carCustomerRepository;

  @Autowired
  private CarInfoRepository carInfoRepository;

  // to find a reservation by an id
  public CarReservation getResInfo(long resID) {

    CarReservation carReservation = carReservationRepository.findByReservationID(resID);

    // return the first (only) car reservation (type CarReservation)
    return carReservation;
  }

  // to find a reservation by an email
  public Iterable<CarReservation> getResInfo(String email) {

    Iterable<CarReservation> carReservation = carReservationRepository.findByEmail(email);

    return carReservation;
  }

  // to find all reservations
  public Iterable<CarReservation> getResInfo() {

    Iterable<CarReservation> carReservation = (Iterable<CarReservation>) carReservationRepository.findAll();

    // return the Iterable of type CarReservation
    return carReservation;
  }

  // to create a new reservation with api
  public CarReservation newRes(NewApiReservation newApiReservation)
      throws ParseException {

    // figure out car cost
    float tempCost = 0;
    if (newApiReservation.getCarType().equals("SUV")) {
      tempCost = 150;
    }
    else if (newApiReservation.getCarType().equals("Fullsize")) {
      tempCost = 125;
    }
    else if (newApiReservation.getCarType().equals("Economy")) {
      tempCost = 110;
    }
    else {
      tempCost = 5;
    }

    System.out.println("Car type was :" + newApiReservation.getCarType());
    System.out.println("cost is :" + tempCost);

    CarInfo tempCar = new CarInfo (newApiReservation.getCarType(), true);
    System.out.println("CarInfo created");

    // calculate total and add to carReservation
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
    Date pickup = sdf.parse(newApiReservation.getPickupDate());
    Date dropoff = sdf.parse(newApiReservation.getReturnDate());

    System.out.println("pickup date " + pickup);
    System.out.println("dropoff date " + dropoff);

    long diffInMillies = Math.abs(dropoff.getTime() - pickup.getTime());
    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

    System.out.println(diffInMillies);
    System.out.println(diff);

    // multiply by days
    tempCost = tempCost * diff;

    CarReservation carReservation = new CarReservation (newApiReservation.getEmail(),
        newApiReservation.getPickupLocation(), newApiReservation.getPickupDate(),
        newApiReservation.getReturnLocation(), newApiReservation.getReturnDate(),
        tempCar.getCarID(), tempCost);

    carInfoRepository.save(tempCar);
    carReservationRepository.save(carReservation);

    return carReservation;
  }

  // to delete a car reservation
  public CarReservation cancelRes(long resID) {

    CarReservation cancelled = carReservationRepository.findByReservationID(resID);

    carReservationRepository.delete(cancelled);

    return cancelled;
  }
}

