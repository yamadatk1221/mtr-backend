package mtr_backend.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "PLACES")
public class Place extends BaseEntity {

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
    @Column(name = "CATEGORY_ID", nullable = false)
    private Integer categoryId;
    @Column(name = "LAT", nullable = false)
    private BigDecimal lat;
    @Column(name = "LNG", nullable = false)
    private BigDecimal lng;
    @Column(name = "MEMO")
    private String memo;
    @Column(name = "IS_PUBLIC", nullable = false)
    private Boolean isPublic;
    @Column(name = "VALUE", nullable = false)
    private Integer value;
    @Column(name = "CREATE_USER_ID", nullable = false)
    private Integer createUserId;

    public static Place create(String name, Integer categoryId, BigDecimal lat, BigDecimal lng, String memo, Boolean isPublic,
            Integer value, Integer createUserId) {
        Place place = new Place();
        place.name = name;
        place.categoryId = categoryId;
        place.lat = lat;
        place.lng = lng;
        place.memo = memo;
        place.isPublic = isPublic;
        place.value = value;
        place.createUserId = createUserId;
        return place;
    }
    
    public void update(String name, Integer categoryId, BigDecimal lat, BigDecimal lng, String memo, Boolean isPublic,
            Integer value) {
        this.name = name;
        this.categoryId = categoryId;
        this.lat = lat;
        this.lng = lng;
        this.memo = memo;
        this.isPublic = isPublic;
        this.value = value;
    }
}
