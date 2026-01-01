package mtr_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceSearchCondition {
    private Boolean isPublic;
    private Integer categoryId;

    public boolean hasIsPublic() {
        return isPublic != null;
    }
    public boolean hasCategoryId() {
        return categoryId != null;
    }
}
