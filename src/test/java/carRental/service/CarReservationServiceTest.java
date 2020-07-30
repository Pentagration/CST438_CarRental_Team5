package carRental.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import carRental.domain.CarReservation;
import carRental.domain.CarReservationRepository;
import carRental.service.CarReservationService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
 
@SpringBootTest
public class CarReservationServiceTest {

	@Autowired
	private CarReservationService carReservationService;
	
	@MockBean
	private CarReservationRepository carReservationRepository;
	
	@Test
	public void contextLoads() {
	}


	@Test
	public void testReservationFoundID() throws Exception {

		// create a new car reservation
		CarReservation carReservation = new CarReservation(
				1,
				"test@email.com",
				"San Diego",
				"1/1/2021",
				"San Diego",
				"1/2/2021",
				1
		);

		// stub for the CarReservationRepository.
		given(carReservationRepository.findByReservationID(1)).willReturn(carReservation);

		CarReservation testReservation = carReservationService.getResInfo(1);

		// Assertions
		assertThat(testReservation).isEqualTo(carReservation);

	}
	
	@Test
	public void  testReservationNotFoundID() {

		// create a new car reservation
		CarReservation carReservation = new CarReservation(
				1,
				"test@email.com",
				"San Diego",
				"1/1/2021",
				"San Diego",
				"1/2/2021",
				1
		);

		// stub for the CarReservationRepository.
		given(carReservationRepository.findByReservationID(1)).willReturn(carReservation);


		CarReservation testReservation = carReservationService.getResInfo(9999);
		CarReservation expectedResult = null;

		// Assertions
		assertThat(testReservation).isEqualTo(expectedResult);
	}

	@Test
	public void testReservationFoundEmail() throws Exception {

		// create a new car reservation
		CarReservation carReservation1 = new CarReservation(
				1,
				"test@email.com",
				"San Diego",
				"1/1/2021",
				"San Diego",
				"1/2/2021",
				1
		);

		List<CarReservation> carReservation = new ArrayList<CarReservation>();

		carReservation.add(carReservation1);

		// stub for the CarReservationRepository.
		given(carReservationRepository.findByEmail("test@email.com")).willReturn(carReservation);

		Iterable<CarReservation> testReservation = carReservationService.getResInfo("test@email.com");

		// Assertions
		assertThat(testReservation).isEqualTo(carReservation);
	}

	@Test
	public void  testReservationNotFoundEmail() {

		// create a new car reservation
		CarReservation carReservation1 = new CarReservation(
				1,
				"test@email.com",
				"San Diego",
				"1/1/2021",
				"San Diego",
				"1/2/2021",
				1
		);

		List<CarReservation> carReservation = new ArrayList<CarReservation>();

		carReservation.add(carReservation1);

		// stub for the CarReservationRepository.
		given(carReservationRepository.findByEmail("test@email.com")).willReturn(carReservation);

		Iterable<CarReservation> testReservation = carReservationService.getResInfo("test2@email.com");
		Iterable<CarReservation> expectedResult = null;

		// Assertions
		assertThat(testReservation).isEqualTo(carReservation);
	}

	@Test
	public void  testCityMultiple() {
		// create 3 countries to simulate cities with the same name in multiple countries
		Country country = new Country("TST", "TestCountry");
		Country country2 = new Country("TST2", "TestCountry2");
		Country country3 = new Country("TST3", "TestCountry3");

		// create cities for each country
		City city = new City(1, "TestCity", "TST", "DistrictTest", 123456);
		City city2 = new City(1, "TestCity", "TST2", "DistrictTest2", 1234562);
		City city3 = new City(1, "TestCity", "TST3", "DistrictTest3", 1234563);

		// Create an empty cities list to be used on the given
		List<City> cities = new ArrayList<City>();
		cities.add(city);
		cities.add(city2);
		cities.add(city3);

		// create the stub calls and return data for weather service
		//  when the getTempAndTime method is called with name parameter "TestCity",
		//  the stub will return the given temp (in degrees Kelvin) and time.
		given(weatherService.getTempAndTime("TestCity"))
				.willReturn(new TempAndTime(295.37, 1593890000, -14400));

		// stub for the CityRepository.  When given input parm of "TestCity",
		// it will return a list of cities populated above by our multiple cities.
		given(cityRepository.findByName("TestCity")).willReturn(cities);

		// stub for the CountryRepository.  When given input parm of country code,
		// it will return the country created above.
		given(countryRepository.findByCode("TST")).willReturn(country);
		given(countryRepository.findByCode("TST2")).willReturn(country2);
		given(countryRepository.findByCode("TST3")).willReturn(country3);

		CityInfo cityResult = cityService.getCityInfo("TestCity");
		CityInfo expectedResult = new CityInfo(1, "TestCity", "TST", "TestCountry", "DistrictTest",
				123456, 72.0, "15:13");

		// Assertions
		assertThat(cityResult).isEqualTo(expectedResult);
	}

	@Test
	public void  testNewReservation() {

	}

	@Test
	public void  testCancelReservation() {

	}
}