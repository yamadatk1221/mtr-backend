package mtr_backend.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mtr_backend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import mtr_backend.response.UserResponse;
import mtr_backend.response.SimpleResponse;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import mtr_backend.request.UserRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RequiredArgsConstructor
@RestController
public class UserController {
    
    final private UserService userService;

    @GetMapping("/users")
    public SimpleResponse<List<UserResponse>> getAllUsers() {
        List<UserResponse> response = userService.getAllUsers()
                .stream()
                .map(userEntity -> UserResponse.form(userEntity))
                .toList();
        return SimpleResponse.ok(response);
    }

    @GetMapping("/users/{id}")
    public SimpleResponse<UserResponse> getUserById(@PathVariable int id) {
        UserResponse response = UserResponse.form(userService.getUserById(id));
        return SimpleResponse.ok(response);
    }
    
    @PostMapping("/users")
    public SimpleResponse<UserResponse> createUser(@RequestBody UserRequest req) {
        UserResponse response = UserResponse.form(userService.createUser(req));
        return SimpleResponse.ok(response);
    }

    @PutMapping("/users/{id}")
    public SimpleResponse<UserResponse> updateUser(@RequestBody UserRequest req, @PathVariable int id) {
        UserResponse response = UserResponse.form(userService.updateUser(id, req));
        return SimpleResponse.ok(response);
    }

    @DeleteMapping("/users/{id}")
    public SimpleResponse<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return SimpleResponse.ok(null);
    }
}
