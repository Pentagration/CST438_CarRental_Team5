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
//  public CarReservation getResInfo(int resID) {
//
//    List<CarReservation> carReservation = (List<CarReservation>) carReservationRepository.findByID(resID);
//    // check to see if there is even a return
//    if (carReservation.size() == 0) {
//      return null;
//    }
//    // return the first (only) car reservation (type CarReservation)
//    return carReservation.get(0);
//  }

  // to find all reservations
  public Iterable<CarReservation> getResInfo() {

    List<CarReservation> carReservation = (List<CarReservation>) carReservationRepository.findAll();
    // check to see if there is even a return
    if (carReservation.size() == 0) {
      return null;
    }
    // return the Iterable of type CarReservation
    return carReservation;
  }

}
