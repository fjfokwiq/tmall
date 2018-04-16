package com.okw.service.impl;

import com.okw.mapper.CategoryMapper;
import com.okw.pojo.Category;
import com.okw.pojo.CategoryExample;
import com.okw.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("serviceImpl")
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper mapper;


    @Override
    public List<Category> listCategory() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("id desc");
        return mapper.selectByExample(example);
    }

    @Override
    public void addCategory(Category category) {
        mapper.insertSelective(category);
    }

    @Override
    public void deleteCategory(int id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Category getCategory(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateCategory(Category category) {
        mapper.updateByPrimaryKeySelective(category);
    }

}
