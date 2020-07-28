package carRental.service;

import carRental.domain.CarReservation;
import carRental.domain.CarReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarReservationService {

  @Autowired
  private CarReservationRepository carReservationRepository;

  // to find a reservation by an id
  // currently written with reservation ID, but may need to change
  public CarReservation getResInfo(long resID) {

    CarReservation carReservation = carReservationRepository.findByReservationID(resID);

    // return the first (only) car reservation (type CarReservation)
    return carReservation;
  }

  // to find all reservations
  public Iterable<CarReservation> getResInfo() {

    Iterable<CarReservation> carReservation = (Iterable<CarReservation>) carReservationRepository.findAll();

    // return the Iterable of type CarReservation
    return carReservation;
  }

  // to create a new reservation with api
  public CarReservation newRes(CarReservation carReservation) {

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

