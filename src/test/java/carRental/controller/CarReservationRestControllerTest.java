package carRental.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import carRental.domain.CarReservation;
import carRental.service.CarReservationService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.DataInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CarReservationRestController.class)
public class CarReservationRestControllerTest {

	@MockBean
	private CarReservationService carReservationService;

	@Autowired
	private MockMvc mvc;

	// This object will be magically initialized by the initFields method below.
	private JacksonTester<CarReservation> json;

	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void contextLoads() {}

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

    // stub for the CarReservationService.
    given(carReservationService.getResInfo(1)).willReturn(carReservation);

    // id to pass in for JSON body content
    String id = "1";

    // perform the test by making simulated HTTP get using URL of "/api/reservation/id"
    MockHttpServletResponse response = mvc.perform(get("/api/reservation/id").contentType(APPLICATION_JSON_UTF8)
				.content(id)).andReturn().getResponse();

    // verify that result is as expected
    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    // convert returned data from JSON string format to City object
    CarReservation result = json.parseObject(response.getContentAsString());

    CarReservation expectedResult = new CarReservation(
        1,
        "test@email.com",
        "San Diego",
        "1/1/2021",
        "San Diego",
        "1/2/2021",
        1
    );

    // Assertions
    assertThat(result).isEqualTo(expectedResult);

  }

	@Test
	public void testReservationNotFoundID() throws Exception {
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

		// stub for the CarReservationService.
		given(carReservationService.getResInfo(1)).willReturn(carReservation);

		// using a different ID for failure test
		String id = "2";

		// perform the test by making simulated HTTP get using URL of "/api/reservation/id"
		MockHttpServletResponse response = mvc.perform(get("/api/reservation/id").contentType(APPLICATION_JSON_UTF8)
				.content(id)).andReturn().getResponse();

		// verify that result is as expected
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
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

		// stub for the CarReservationService.
		given(carReservationService.getResInfo("test@email.com")).willReturn(carReservation);

		// id to pass in for JSON body content
		String email = "test@email.com";

		// perform the test by making simulated HTTP get using URL of "/api/reservation/email"
		MockHttpServletResponse response = mvc.perform(get("/api/reservation/email").contentType(APPLICATION_JSON_UTF8)
				.content(email)).andReturn().getResponse();

		String stringResponse = mvc.perform(get("/api/reservation/email").contentType(APPLICATION_JSON_UTF8)
				.content(email)).andReturn().getResponse().getContentAsString();

		// verify that result is as expected
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

		// convert returned data from JSON string format to City object
		ObjectMapper mapper = new ObjectMapper();
		List<CarReservation> resultList = mapper.readValue
				(stringResponse, new TypeReference<List<CarReservation>>() {});

		CarReservation expectedResult1 = new CarReservation(
				1,
				"test@email.com",
				"San Diego",
				"1/1/2021",
				"San Diego",
				"1/2/2021",
				1
		);

		List<CarReservation> expectedResult = new ArrayList<CarReservation>();

		expectedResult.add(expectedResult1);

		// Assertions
		assertThat(resultList).isEqualTo(expectedResult);

	}

	@Test
	public void testReservationNotFoundEmail() throws Exception {
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

		// stub for the CarReservationService.
		given(carReservationService.getResInfo("test@email.com")).willReturn(carReservation);

		//  to pass in for JSON body content
		String email = "test2@email.com";

		// perform the test by making simulated HTTP get using URL of "/api/reservation/email"
		MockHttpServletResponse response = mvc.perform(get("/api/reservation/email").contentType(APPLICATION_JSON_UTF8)
				.content(email)).andReturn().getResponse();

		String stringResponse = mvc.perform(get("/api/reservation/email").contentType(APPLICATION_JSON_UTF8)
				.content(email)).andReturn().getResponse().getContentAsString();

		// verify that result is as expected
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

		// convert returned data from JSON string format to City object
		ObjectMapper mapper = new ObjectMapper();
		List<CarReservation> resultList = mapper.readValue
				(stringResponse, new TypeReference<List<CarReservation>>() {});

		List<CarReservation> expectedResult = new ArrayList<CarReservation>();

		// Assertions
		assertThat(resultList).isEqualTo(expectedResult);
	}
}
