package mtr_backend.controller;

import mtr_backend.service.CategoryService;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import mtr_backend.response.CategoryResponse;
import mtr_backend.response.SimpleResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public SimpleResponse<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> response =  categoryService.getAllCategories()
                .stream()
                .map(categoryEntity -> CategoryResponse.from(categoryEntity))
                .toList();
        return SimpleResponse.ok(response);
    }
}
