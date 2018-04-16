package com.okw.service;

import com.okw.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProductService {
    List<Product> listProduct(int cid);

    Product getProduct(int id);

    void addProduct(Product product);

    void deleteProduct(int id);

    void updateProduct(Product product);


}
