package com.okw.controller;

import com.okw.pojo.Product;
import com.okw.pojo.ProductImage;
import com.okw.service.IProductImageService;
import com.okw.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductImageController {
    @Autowired
    @Qualifier("productService")
    private IProductService productService;

    @Autowired
    @Qualifier("productImageService")
    private IProductImageService productImageService;

    @RequestMapping("admin_productImage_add")
    public String addProductImage(ProductImage productImage, HttpSession session, @RequestParam("image") MultipartFile image) throws IOException {
        productImageService.addProductImage(productImage);
        String fileName = productImage.getId() + ".jpg";
        String imageFolder;
        if (productImage.getType().equals(productImageService.type_single)) {
            imageFolder = session.getServletContext().getRealPath("img/productSingle");
        } else {
            imageFolder = session.getServletContext().getRealPath("img/productDetail");
        }
        File f = new File(imageFolder, fileName);
        image.transferTo(f);
        f.getParentFile().mkdirs();

        return "redirect:admin_productImage_list?pid="+productImage.getPid();
    }


    @RequestMapping("admin_productImage_list")
    public String listProductImage(Model model, int pid) {
        Product product = productService.getProduct(pid);
        List<ProductImage> productImageListSingle = productImageService.listProductImage(pid, IProductImageService.type_single);
        List<ProductImage> productImageListDetail = productImageService.listProductImage(pid, IProductImageService.type_detail);
        model.addAttribute("product", product);
        model.addAttribute("productImageListSingle", productImageListSingle);
        model.addAttribute("productImageListDetail", productImageListDetail);
        return "admin/listProductImage";
    }

    @RequestMapping("admin_productImage_delete")
    public String deleteProductImage(int id, HttpSession session) {
        ProductImage productImage=productImageService.getProductImage(id);
        String imageName = productImage.getId() + ".jpg";
        String imageFolder;
        if (productImage.getType().equals(productImageService.type_single)) {
            imageFolder = session.getServletContext().getRealPath("img/productSingle");
            File imageFile = new File(imageFolder, imageName);
            imageFile.delete();
        }else {
            imageFolder = session.getServletContext().getRealPath("img/productDetail");
            File imageFile = new File(imageFolder, imageName);
            imageFile.delete();
        }
        productImageService.deleteProductImage(id);
        return "redirect:admin_productImage_list?pid="+productImage.getPid();
    }
}
