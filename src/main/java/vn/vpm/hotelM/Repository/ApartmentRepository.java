package vn.vpm.hotelM.Repository;

import org.springframework.data.repository.CrudRepository;
import vn.vpm.hotelM.domain.Apartment;

public interface ApartmentRepository extends CrudRepository<Apartment, String> {
}
