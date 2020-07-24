package carRental.domain;

import org.springframework.data.repository.CrudRepository;

public interface CarReservationRepository extends CrudRepository<CarReservation, Long> {
  CarReservation findByID(int resID);
  Iterable<CarReservation> findAll();
}
