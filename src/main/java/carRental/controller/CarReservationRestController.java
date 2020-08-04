package carRental.controller;

import carRental.domain.CarReservation;
import carRental.service.CarReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarReservationRestController {

  @Autowired
  private CarReservationService carReservationService;

  // this is a get method for finding all reservations
  @GetMapping("/api/reservations")
  public ResponseEntity<Iterable<CarReservation>> getAllCarReservation() {
    Iterable<CarReservation> carReservation = carReservationService.getResInfo();

    // look up city info from database.  Might be multiple cities with same name.
    if (carReservation == null) {
      // reservation not found.  Send 404 return code.
      return new ResponseEntity<Iterable<CarReservation>>( HttpStatus.NOT_FOUND);
    } else {
      // return 200 status code (OK) and city information in JSON format
      return new ResponseEntity<Iterable<CarReservation>>(carReservation, HttpStatus.OK);
    }
  }

  // this is a get method for finding a single reservation by reservation id
  @GetMapping(value = "/api/reservation/id", consumes = "application/json", produces = "application/json")
  public ResponseEntity<CarReservation> getSingleCarReservation(@RequestBody long resID) {

    CarReservation carReservation = carReservationService.getResInfo(resID);

    // look up city info from database.  Might be multiple cities with same name.
    if (carReservation == null) {
      // reservation not found.  Send 404 return code.
      return new ResponseEntity<CarReservation>( HttpStatus.NOT_FOUND);
    } else {
      // return 200 status code (OK) and information in JSON format
      return new ResponseEntity<CarReservation>(carReservation, HttpStatus.OK);
    }
  }

  // this is a get method for finding all reservations by email
  @GetMapping(value = "/api/reservation/email", consumes = "application/json", produces = "application/json")
  public ResponseEntity<List<CarReservation>> getEmailCarReservation(@RequestBody String email) {

    List<CarReservation> carReservation = carReservationService.getResInfo(email);

    // look up city info from database.  Might be multiple cities with same name.
    if (carReservation.size() == 0) {
      // reservation not found.  Send 404 return code.
      return new ResponseEntity<List<CarReservation>>( HttpStatus.NOT_FOUND);
    } else {
      // return 200 status code (OK) and information in JSON format
      return new ResponseEntity<List<CarReservation>>(carReservation, HttpStatus.OK);
    }
  }

  // this is a get method for creating a new reservation
  @PostMapping(value = "/api/reservation/new", consumes = "application/json", produces = "application/json")
  public ResponseEntity<CarReservation> createNewCarReservation(@RequestBody CarReservation carReservation) {

    carReservation = carReservationService.newRes(carReservation);

    if (carReservation == null) {
      // reservation not found.  Send 404 return code.
      return new ResponseEntity<CarReservation>( HttpStatus.NOT_FOUND);
    } else {
      // return 200 status code (OK) and information in JSON format
      return new ResponseEntity<CarReservation>(carReservation, HttpStatus.OK);
    }
  }

  // this is a delete method for deleting a reservation
  @DeleteMapping(value = "/api/reservation/cancel", consumes = "application/json")
  public ResponseEntity<Void> cancelReservation(@RequestBody long resID) {

    CarReservation cancelledReservation = carReservationService.cancelRes(resID);

    if (cancelledReservation == null) {
      // reservation not found.  Send 404 return code.
      return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    } else {
      // return 204 status code (No Content) and information in JSON format
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

}