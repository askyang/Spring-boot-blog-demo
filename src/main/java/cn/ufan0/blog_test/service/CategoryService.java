package cn.ufan0.blog_test.service;

import cn.ufan0.blog_test.entity.Category;

import java.util.List;

public interface CategoryService {

    void addCategory(Category category);

    List<Category> getCategory();

    void updateCategory(Category category);

    void deleteCategory(Integer id);


}
