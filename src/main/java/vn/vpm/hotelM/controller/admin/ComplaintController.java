//package vn.vpm.hotelM.controller.admin;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import vn.vpm.hotelM.Service.ComplaintService;
//import vn.vpm.hotelM.domain.Complaint;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/complaints")
//public class ComplaintController {
//
//    @Autowired
//    private ComplaintService complaintService;
//
//    @PostMapping
//    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
//        Complaint savedComplaint = complaintService.saveComplaint(complaint);
//        return ResponseEntity.ok(savedComplaint);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Complaint> updateComplaint(@PathVariable String id, @RequestBody Complaint updatedComplaint) {
//        Complaint complaint = complaintService.updateComplaint(id, updatedComplaint);
//        if (complaint != null) {
//            return ResponseEntity.ok(complaint);
//        } else {
//            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Complaint>> getAllComplaints() {
//        List<Complaint> complaints = complaintService.getAllComplaints();
//        return ResponseEntity.ok(complaints);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Complaint> getComplaintById(@PathVariable String id) {
//        Optional<Complaint> complaint = complaintService.getComplaintById(id);
//        return complaint.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteComplaint(@PathVariable String id) {
//        complaintService.deleteComplaint(id);
//        return ResponseEntity.noContent().build();
//    }
//}
