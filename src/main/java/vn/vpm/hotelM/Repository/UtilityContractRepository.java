package vn.vpm.hotelM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.vpm.hotelM.domain.UtilityContract;

@Repository
public interface UtilityContractRepository extends JpaRepository<UtilityContract, String> {
}
