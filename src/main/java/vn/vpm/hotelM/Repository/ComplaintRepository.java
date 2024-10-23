package vn.vpm.hotelM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.vpm.hotelM.domain.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, String> {
}
