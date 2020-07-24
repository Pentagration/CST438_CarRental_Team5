package carRental.domain;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarReservationRepository extends CrudRepository<CarReservation, Long> {
//  CarReservation findByID(int resID);
//  Iterable<CarReservation> findAll();
	
	//@Query(value = "SELECT * FROM Users u WHERE u.status = ?1", nativeQuery = true)
	//User findUserByStatusNative(Integer status);
	
	@Query(value= "Select * from reservation u WHERE u.email =?1", nativeQuery = true)
	List<CarReservation> findByEmail(String email);
	
	
}
