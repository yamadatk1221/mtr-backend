package mtr_backend.repository;

import mtr_backend.entity.Place;
import mtr_backend.repository.impl.PlaceRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Integer>, PlaceRepositoryCustom {

}