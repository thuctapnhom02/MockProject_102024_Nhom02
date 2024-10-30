//package vn.vpm.hotelM.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import vn.vpm.hotelM.Repository.ApartmentRepository;
//import vn.vpm.hotelM.domain.Apartment;
//
//import java.util.Optional;
//
//@Service
//public class ApartmentService {
//
//    @Autowired
//    private ApartmentRepository apartmentRepository;
//
//    // Lưu Apartment
//    public Apartment saveApartment(Apartment apartment) {
//        return apartmentRepository.save(apartment);
//    }
//
//    // Cập nhật Apartment theo id
//    public Apartment updateApartment(String id, Apartment updatedApartment) {
//        Optional<Apartment> existingApartmentOptional = apartmentRepository.findById(id);
//        if (existingApartmentOptional.isPresent()) {
//            Apartment existingApartment = existingApartmentOptional.get();
//            existingApartment.setFlor(updatedApartment.getFlor());
//            existingApartment.setStatus(updatedApartment.getStatus());
//            existingApartment.setNumApartment(updatedApartment.getNumApartment());
//            existingApartment.setNumBedroom(updatedApartment.getNumBedroom());
//            existingApartment.setSquare(updatedApartment.getSquare());
//            existingApartment.setRentPrice(updatedApartment.getRentPrice());
//            existingApartment.setAddress(updatedApartment.getAddress());
//            return apartmentRepository.save(existingApartment); // Lưu lại căn hộ đã cập nhật
//        }
//        return null; // Trả về null nếu không tìm thấy căn hộ
//    }
//
//    // Xóa Apartment theo id
//    public void deleteApartment(String id) {
//        apartmentRepository.deleteById(id);
//    }
//}
