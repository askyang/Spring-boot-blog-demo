package cn.ufan0.blog_test.controller;

import cn.ufan0.blog_test.entity.Category;
import cn.ufan0.blog_test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }

    @Secured("ROLE_USER")
    @PostMapping("/category")
    public void addCategory(Category category) {
        if (category.getTitle() != null && !category.getTitle().equals("")) {
            categoryService.addCategory(category);
        }
    }

    @Secured("ROLE_USER")
    @PutMapping("/category")
    public void updateCategory(Category category) {
        if (category.getId() != null && (category.getTitle() != null || category.getDescription() != null)) {
            categoryService.updateCategory(category);
        }
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/category")
    public void deleteCategory(Integer id) {
        categoryService.deleteCategory(id);
    }

}
