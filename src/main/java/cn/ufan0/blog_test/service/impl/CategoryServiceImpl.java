package cn.ufan0.blog_test.service.impl;

import cn.ufan0.blog_test.entity.Category;
import cn.ufan0.blog_test.mapper.CategoryMapper;
import cn.ufan0.blog_test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    @Override
    public List<Category> getCategory() {
        return categoryMapper.getCategory();
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryMapper.deleteCategory(id);
    }
}
