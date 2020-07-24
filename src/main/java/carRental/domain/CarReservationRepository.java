package carRental.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarReservationRepository extends CrudRepository<CarReservation, Long> {

  CarReservation findByCustomerID(long resID);

  Iterable<CarReservation> findAll();
  
  @Query(value= "Select * from reservation u WHERE u.email =?1", nativeQuery = true)
  List<CarReservation> findByEmail(String email);
}
