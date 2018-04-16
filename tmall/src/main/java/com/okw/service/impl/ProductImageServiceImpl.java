package com.okw.service.impl;

import com.okw.mapper.ProductImageMapper;
import com.okw.pojo.ProductImage;
import com.okw.pojo.ProductImageExample;
import com.okw.service.IProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productImageService")
public class ProductImageServiceImpl implements IProductImageService {
    @Autowired
    ProductImageMapper productImageMapper;
    @Override
    public List<ProductImage> listProductImage(int pid, String type) {
        ProductImageExample example=new ProductImageExample();
        example.createCriteria().andPidEqualTo(pid).andTypeEqualTo(type);
        example.setOrderByClause("id desc");
        List<ProductImage> productImages=productImageMapper.selectByExample(example);
        return productImages;
    }

    @Override
    public ProductImage getProductImage(int id) {
        return productImageMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addProductImage(ProductImage productImage) {
        productImageMapper.insertSelective(productImage);
    }

    @Override
    public void deleteProductImage(int id) {
        productImageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateProductImage(ProductImage productImage) {
        productImageMapper.updateByPrimaryKeySelective(productImage);
    }
}
