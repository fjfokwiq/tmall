package com.okw.controller;

import com.okw.pojo.Category;
import com.okw.pojo.Product;
import com.okw.service.ICategoryService;
import com.okw.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    @Qualifier("productService")
    private IProductService productService;

    @Autowired
    @Qualifier("serviceImpl")
    private ICategoryService categoryService;

    @RequestMapping("admin_product_list")
    public String listProduct(Model model, int cid) {
        Category category = categoryService.getCategory(cid);
        List<Product> products = productService.listProduct(cid);
        model.addAttribute("products", products);
        model.addAttribute("category", category);

        return "admin/listProduct";
    }

    @RequestMapping("admin_product_add")
    public String addProduct(Model model, Product product) {
        product.setCreateDate(new Date());
        productService.addProduct(product);
        return "redirect:admin_product_list?cid=" + product.getCid();
    }

    @RequestMapping("admin_product_edit")
    public String editProduct(Model model, int id) {
        Product product = productService.getProduct(id);
        product.setCategory(categoryService.getCategory(product.getId()));
        model.addAttribute("product", product);
        return "admin/editProduct";
    }

    @RequestMapping("admin_product_update")
    public String updateProduct(Model model, Product product) {
        productService.updateProduct(product);
        return "redirect:admin_product_list?cid=" + product.getCid();
    }

    @RequestMapping("admin_product_delete")
    public String deleteProduct(Model model, int id) {
        Product product = productService.getProduct(id);
        productService.deleteProduct(id);
        return "redirect:admin_product_list?cid="+product.getCid();
    }
}
