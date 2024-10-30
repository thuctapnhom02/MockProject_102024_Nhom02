//package vn.vpm.hotelM.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import vn.vpm.hotelM.Service.ApartmentService;
//import vn.vpm.hotelM.domain.Apartment;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/apartments")
//public class ApartmentController {
//
//    @Autowired
//    private ApartmentService apartmentService;
//
//    @PostMapping
//    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {
//        Apartment savedApartment = apartmentService.saveApartment(apartment);
//        return ResponseEntity.ok(savedApartment);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Apartment> updateApartment(@PathVariable String id, @RequestBody Apartment updatedApartment) {
//        Apartment apartment = apartmentService.updateApartment(id, updatedApartment);
//        if (apartment != null) {
//            return ResponseEntity.ok(apartment);
//        } else {
//            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy
//        }
//    }
//
//    // Xóa Apartment theo id
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteApartment(@PathVariable String id) {
//        apartmentService.deleteApartment(id);
//        return ResponseEntity.noContent().build();
//    }
//}
