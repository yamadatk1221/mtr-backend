package mtr_backend.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mtr_backend.entity.Place;

@Getter
@AllArgsConstructor
public class PlaceResponse {
    private int id;
    private String name;
    private Integer categoryId;
    private BigDecimal lat;
    private BigDecimal lng;
    private String memo;
    private Boolean isPublic;
    private Integer value;
    private Integer createUserId;
    private String createdAt;
    private String updatedAt;

    public static PlaceResponse from(Place place) {
        return new PlaceResponse(
            place.getId(),
            place.getName(),
            place.getCategoryId(),
            place.getLat(),
            place.getLng(),
            place.getMemo(),
            place.getIsPublic(),
            place.getValue(),
            place.getCreateUserId(),
            place.getCreatedAt().toString(),
            place.getUpdatedAt().toString()
        );
    }
}
