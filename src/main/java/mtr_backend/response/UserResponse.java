package mtr_backend.response;

import lombok.AllArgsConstructor;
import mtr_backend.entity.User;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponse {
    
    private int id;
    private String name;
    private boolean isAdmin;
    private String createdAt;
    private String updatedAt;

    public static UserResponse form(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.isAdmin(),
                user.getCreatedAt().toString(),
                user.getUpdatedAt().toString()
        );
    }

}
