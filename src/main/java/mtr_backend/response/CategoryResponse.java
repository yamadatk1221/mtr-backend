package mtr_backend.response;

import lombok.AllArgsConstructor;
import mtr_backend.entity.Category;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryResponse {
    
    private int id;
    private String name;
    private String createdAt;
    private String updatedAt;

    public static CategoryResponse from(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getCreatedAt().toString(),
                category.getUpdatedAt().toString()
        );
    }

}
