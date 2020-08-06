package carRental.domain;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarInfoRepository extends CrudRepository<CarInfo, Long> {

  CarInfo findByCarID(long carID);

}
