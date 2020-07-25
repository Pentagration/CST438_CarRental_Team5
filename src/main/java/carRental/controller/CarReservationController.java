package carRental.controller;

import carRental.domain.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarReservationController {
  @Autowired
  private CarReservationRepository carReservationRepository;
  @Autowired
  private CarInfoRepository carInfoRepository;
  @Autowired
  private CarCustomerRepository carCustomerRepository;
  
  @GetMapping("")
  public String index(Model model) {
	  String email = new String();
	  model.addAttribute("email", email);
	  return "index";
  }
  
  @PostMapping("")
  public String searchReservationsEmail(@RequestParam("email") String email, Model model) {
	  // function(email);
	  return "user_reservations";
  }

    /*
  localhost:8080/reservation/new
  presents the user the car_reservation.html page to fill-out
   */
  @GetMapping("/reservation/new")
  public String createReservation(Model model){
    CarReservation carReservation = new CarReservation();
    CarInfo carInfo = new CarInfo();
    CarCustomer carCustomer = new CarCustomer();
    model.addAttribute("carReservation", carReservation);
    model.addAttribute("carInfo", carInfo);
    model.addAttribute("carCustomer", carCustomer);
    return "car_reservation";
  }

  /*
  localhost:8080/reservation/new
  presents the user the car_confirmation.html page to fill-out
   */
  @PostMapping("/reservation/new")
  public String processCarReservation(@Valid CarReservation carReservation,@Valid CarInfo carInfo, @Valid CarCustomer carCustomer,
      BindingResult result, Model model){
    carReservationRepository.save(carReservation);
    carCustomerRepository.save(carCustomer);
    carInfoRepository.save(carInfo);
    return "car_confirmation";
  }
}
