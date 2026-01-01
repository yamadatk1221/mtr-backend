package mtr_backend.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import mtr_backend.repository.PlaceRepository;
import mtr_backend.dto.PlaceSearchCondition;
import mtr_backend.entity.Place;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {
    
    private final PlaceRepository placeRepository;

    public List<Place> searchPlaces(PlaceSearchCondition condition) {
        return placeRepository.findByConditions(condition);
    }
}
