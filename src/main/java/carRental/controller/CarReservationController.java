package carRental.controller;

import carRental.domain.CarReservation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarReservationController {
  @Autowired
  carRental.domain.CarReservationRepository CarReservationRepository;

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
          CarReservationRepository.save(carReservation);
          return "car_confirmation";
    }
}
