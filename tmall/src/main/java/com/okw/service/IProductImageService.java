package com.okw.service;

import com.okw.pojo.ProductImage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductImageService {

    String type_single = "type_single";
    String type_detail = "type_detail";

    List<ProductImage> listProductImage(int pid, String type);

    ProductImage getProductImage(int id);

    void addProductImage(ProductImage productImage);

    void deleteProductImage(int id);

    void updateProductImage(ProductImage productImage);
}
