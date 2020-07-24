package carRental.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarReservationRepository extends CrudRepository<CarReservation, Long> {
//  @Query()
  CarReservation findByCustomerID(int resID);

  Iterable<CarReservation> findAll();
}
