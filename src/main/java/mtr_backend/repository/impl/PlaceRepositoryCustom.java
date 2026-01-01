package mtr_backend.repository.impl;
import mtr_backend.dto.PlaceSearchCondition;
import mtr_backend.entity.Place;
import java.util.List;

public interface PlaceRepositoryCustom {
  List<Place> findByConditions(PlaceSearchCondition condition);
}
