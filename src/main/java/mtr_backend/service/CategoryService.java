package mtr_backend.service;
import mtr_backend.entity.Category;
import java.util.List;
import mtr_backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mtr_backend.request.CategoryRequest;


@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category createCategory(CategoryRequest req) {
        Category category = Category.create(req.getName());
        return categoryRepository.save(category);
    }

    @Transactional
    public Category updateCategory(CategoryRequest req, int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("category not found: " + id));
        category.update(req.getName());
        return categoryRepository.save(category);
    }

    public void deleteCategory(int id) {
        categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.deleteById(id);
    }
}

