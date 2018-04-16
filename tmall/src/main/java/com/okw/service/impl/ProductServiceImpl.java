package com.okw.service.impl;

import com.okw.mapper.ProductMapper;
import com.okw.pojo.Product;
import com.okw.pojo.ProductExample;
import com.okw.service.ICategoryService;
import com.okw.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productService")
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    @Qualifier("serviceImpl")
    private ICategoryService categoryService;

    @Override
    public List<Product> listProduct(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List<Product> productList=productMapper.selectByExample(example);
        return productList;
    }

    @Override
    public Product getProduct(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addProduct(Product product) {
        productMapper.insertSelective(product);
    }

    @Override
    public void deleteProduct(int id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }
}
