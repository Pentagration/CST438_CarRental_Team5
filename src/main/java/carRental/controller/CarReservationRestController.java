package carRental.controller;

import carRental.domain.CarReservation;
import carRental.service.CarReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarReservationRestController {

  @Autowired
  private CarReservationService carReservationService;

  // this is a get method for finding all reservations
  @GetMapping("/api/reservations")
  public ResponseEntity<Iterable<CarReservation>> getAllCarReservation() {
    Iterable<CarReservation> carReservation = carReservationService.getResInfo();
    System.out.println("all reservations");
    // look up city info from database.  Might be multiple cities with same name.
    if (carReservation == null) {
      // reservation not found.  Send 404 return code.
      return new ResponseEntity<Iterable<CarReservation>>( HttpStatus.NOT_FOUND);
    } else {
      // return 200 status code (OK) and city information in JSON format
      return new ResponseEntity<Iterable<CarReservation>>(carReservation, HttpStatus.OK);
    }
  }

  // this is a get method for finding a single reservation
  @GetMapping("/api/reservations/{id}")
  public ResponseEntity<CarReservation> getSingleCarReservation(@PathVariable("id") long custID) {
    CarReservation carReservation = carReservationService.getResInfo(custID);
    System.out.println("one reservation");
    // look up city info from database.  Might be multiple cities with same name.
    if (carReservation == null) {
      // reservation not found.  Send 404 return code.
      return new ResponseEntity<CarReservation>( HttpStatus.NOT_FOUND);
    } else {
      // return 200 status code (OK) and information in JSON format
      return new ResponseEntity<CarReservation>(carReservation, HttpStatus.OK);
    }
  }

  // this is a get method for creating a new reservation
//  @PostMapping("/api/reservations/new")
//  public ResponseEntity<CarReservation> getNewCarReservation(@PathVariable("city") String cityName) {
//    CarReservation carReservation = carReservationService.getResInfo(cityName);
//
//    // look up city info from database.  Might be multiple cities with same name.
//    if (carReservation == null) {
//      // reservation not found.  Send 404 return code.
//      return new ResponseEntity<CarReservation>( HttpStatus.NOT_FOUND);
//    } else {
//      // return 200 status code (OK) and city information in JSON format
//      return new ResponseEntity<CarReservation>(carReservation, HttpStatus.OK);
//    }
//  }

}
