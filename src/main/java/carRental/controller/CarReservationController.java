package carRental.controller;

import carRental.domain.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarReservationController {
  @Autowired
  private CarReservationRepository carReservationRepository;
  
  
  @GetMapping("")
  public String index(Model model) {
	  String email = new String();
	  model.addAttribute("email", email);
	  return "index";
  }
  
  
  @PostMapping("")
  public String searchReservationsEmail(@RequestParam("email") String email, Model model) {
	  //Iterable<CarReservation> reservations = carReservationRepository.findAll();
	  Iterable<CarReservation> reservations = carReservationRepository.findByEmail(email);
	  model.addAttribute("reservations", reservations);
	  return "user_reservation";
  }

    /*
  localhost:8080/reservation/new
  presents the user the car_reservation.html page to fill-out
   */
  @GetMapping("/reservation/new")
  public String createReservation(Model model){
    CarReservation carReservation = new CarReservation();
    model.addAttribute("carReservation", carReservation);
    return "car_reservation";
  }

  /*
  localhost:8080/reservation/new
  presents the user the car_confirmation.html page to fill-out
   */
  @PostMapping("/reservation/new")
  public String processCarReservation(@Valid CarReservation carReservation,
      BindingResult result, Model model){
    carReservationRepository.save(carReservation);
    if (result.hasErrors()) {
      return "car_reservation";
    }
    return "car_confirmation";
  }

  /*
  localhost:8080/reservation/cancel
  presents the user the car_confirmation.html page to fill-out
   */
//  @DeleteMapping("/reservation/{id}")
//  public String deleteCarReservation(@PathVariable long customerID,
//      BindingResult result, Model model){
//    carReservationRepository.deleteByCustomerID(customerID);
//    if (result.hasErrors()) {
//      return "car_reservation";
//    }
//    return "car_cancelled_confirmation";
//  }
}
