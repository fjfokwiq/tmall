package com.okw.service;

import com.okw.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICategoryService {
    List<Category> listCategory();

    void addCategory(Category category);

    void deleteCategory(int id);

    Category getCategory(int id);

    void updateCategory(Category category);
}
