package mtr_backend.controller;

import mtr_backend.service.CategoryService;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import mtr_backend.response.CategoryResponse;
import mtr_backend.response.SimpleResponse;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import mtr_backend.request.CategoryRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequiredArgsConstructor
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public SimpleResponse<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> response = categoryService.getAllCategories()
                .stream()
                .map(categoryEntity -> CategoryResponse.from(categoryEntity))
                .toList();
        return SimpleResponse.ok(response);
    }
    
    @GetMapping("/categories/{id}")
    public SimpleResponse<CategoryResponse> getCategoryById(@PathVariable int id) {
        CategoryResponse response = CategoryResponse.from(categoryService.getCategoryById(id));
        return SimpleResponse.ok(response);
    }

    @PostMapping("/categories")
    public SimpleResponse<CategoryResponse> createCategory(@RequestBody CategoryRequest req) {
        CategoryResponse response = CategoryResponse.from(categoryService.createCategory(req));
        return SimpleResponse.ok(response);
    }

    @PutMapping("/categories/{id}")
    public SimpleResponse<CategoryResponse> updateCategory(@RequestBody CategoryRequest req, @PathVariable int id) {
        CategoryResponse response = CategoryResponse.from(categoryService.updateCategory(req, id));
        return SimpleResponse.ok(response);
    }

    @DeleteMapping("/categories/{id}")
    public SimpleResponse<Void> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return SimpleResponse.ok(null);
    }
}
