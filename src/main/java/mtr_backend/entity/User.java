package mtr_backend.entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Column(name = "NAME", nullable = false, length = 50, unique = true)
    private String name;
    @Column(name="IS_ADMIN" )
    private boolean isAdmin;

    public static User create(String name, boolean isAdmin) {
        User user = new User();
        user.name = name;
        user.isAdmin = isAdmin;
        return user;
    }

    public void update(String name , boolean isAdmin) {
        this.name = name;
        this.isAdmin = isAdmin;
    }
}
