package vn.vpm.hotelM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.vpm.hotelM.domain.ContractLease;

@Repository
public interface ContractLeaseRepository extends JpaRepository<ContractLease, String> {
}