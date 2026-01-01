package mtr_backend.request;

import lombok.Getter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
public class UserRequest {
    
    @NotBlank
    @Size(max = 50)
    private String name;
    private boolean isAdmin;
}
