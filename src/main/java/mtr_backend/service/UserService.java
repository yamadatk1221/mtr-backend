package mtr_backend.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mtr_backend.repository.UserRepository;
import mtr_backend.request.UserRequest;
import mtr_backend.entity.User;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(UserRequest req) {
        User user = User.create(req.getName(), req.isAdmin());
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(int id, UserRequest req) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found" + id));
        user.update(req.getName(), req.isAdmin());
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(id);
    }
    
}
