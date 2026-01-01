package mtr_backend.controller;
import lombok.RequiredArgsConstructor;
import mtr_backend.service.PlaceService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mtr_backend.response.PlaceResponse;
import mtr_backend.response.SimpleResponse;
import mtr_backend.dto.PlaceSearchCondition;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlaceController {
    
    private final PlaceService placeService;

    @GetMapping("/places")
    public SimpleResponse<List<PlaceResponse>> searchPlaces(
        @RequestParam(required = false) Boolean isPublic,
        @RequestParam(required = false) Integer categoryId) {
            PlaceSearchCondition condition = new PlaceSearchCondition();
            condition.setIsPublic(isPublic);
            condition.setCategoryId(categoryId);
                List<PlaceResponse> response = placeService.searchPlaces(condition)
                        .stream()
                        .map(placeEntity -> PlaceResponse.from(placeEntity))
                        .toList();
                return SimpleResponse.ok(response);
    }
}
