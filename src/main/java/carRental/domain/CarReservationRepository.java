package carRental.domain;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarReservationRepository extends CrudRepository<CarReservation, Long> {

	@Query("select m from reservation m where email=")
	List<CarReservation> findAllCarReservationsUsingEmail(email);
	
}
