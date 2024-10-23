package vn.vpm.hotelM.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vpm.hotelM.Repository.ComplaintRepository;
import vn.vpm.hotelM.domain.Complaint;

import java.util.Optional;
import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public Complaint updateComplaint(String id, Complaint updatedComplaint) {
        Optional<Complaint> existingComplaintOptional = complaintRepository.findById(id);
        if (existingComplaintOptional.isPresent()) {
            Complaint existingComplaint = existingComplaintOptional.get();
            existingComplaint.setApartment(updatedComplaint.getApartment());
            existingComplaint.setUser(updatedComplaint.getUser());
            existingComplaint.setComplaintDate(updatedComplaint.getComplaintDate());
            existingComplaint.setExpectedCompletionDate(updatedComplaint.getExpectedCompletionDate());
            existingComplaint.setContentOfComplaint(updatedComplaint.getContentOfComplaint());
            existingComplaint.setProofImg(updatedComplaint.getProofImg());
            existingComplaint.setStaff(updatedComplaint.getStaff());
            existingComplaint.setNote(updatedComplaint.getNote());
            existingComplaint.setStatus(updatedComplaint.getStatus());
            return complaintRepository.save(existingComplaint);
        }
        return null;
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Optional<Complaint> getComplaintById(String id) {
        return complaintRepository.findById(id);
    }

    public void deleteComplaint(String id) {
        complaintRepository.deleteById(id);
    }
}
