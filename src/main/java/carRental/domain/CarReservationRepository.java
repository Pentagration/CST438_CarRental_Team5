package carRental.domain;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarReservationRepository extends CrudRepository<CarReservation, Long> {
//  CarReservation findByID(int resID);
//  Iterable<CarReservation> findAll();
	
	@Query("Select u from reservation u WHERE u.email =?1")
	List<CarReservation> findByEmail(String email);
	
	
}
