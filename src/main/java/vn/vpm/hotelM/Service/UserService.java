package vn.vpm.hotelM.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vpm.hotelM.Repository.UserRepository;
import vn.vpm.hotelM.domain.User;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPhone(updatedUser.getPhone());
            existingUser.setGender(updatedUser.getGender());
            existingUser.setSsn(updatedUser.getSsn());
            existingUser.setStatus(updatedUser.getStatus());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setDebt(updatedUser.getDebt());
            existingUser.setTotalPayment(updatedUser.getTotalPayment());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    // Xóa User theo id
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
