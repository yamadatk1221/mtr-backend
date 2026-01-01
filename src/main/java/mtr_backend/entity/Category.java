package mtr_backend.entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "CATEGORIES")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    @Column(name = "NAME", nullable = false, length = 50 , unique = true)
    private String name;

    public static Category create(String name) {
        Category category = new Category();
        category.name = name;
        return category;
    }

    public void update(String name) {
        this.name = name;
    }
}


