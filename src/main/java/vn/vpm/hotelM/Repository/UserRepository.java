package vn.vpm.hotelM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vpm.hotelM.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}
