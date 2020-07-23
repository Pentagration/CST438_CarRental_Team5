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

  public CarReservation getResInfo(String cityName) {

    List<City> city = cityRepository.findByName(cityName);
    // check to see if there is even a return
    if (city.size() == 0) {
      return null;
    }
    City tempCity = city.get(0);
    Country country = countryRepository.findByCode(tempCity.getCountryCode());
    TempAndTime weather = weatherService.getTempAndTime(cityName);

    return new CityInfo(tempCity, country.getName(), weather.getFarTemp(), weather.getStringTime());
  }

}
