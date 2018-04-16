package com.okw.controller;

import com.github.pagehelper.PageHelper;
import com.okw.pojo.Category;
import com.okw.service.ICategoryService;

import com.okw.until.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    @Qualifier("serviceImpl")
    ICategoryService categoryService;

    @RequestMapping("admin_category_list")
    public String listCategory(Model model, PageInfo pageInfo) {
        PageHelper.offsetPage(pageInfo.getOffset(), pageInfo.getCount());
        List<Category> cs = categoryService.listCategory();
        int total = (int) new com.github.pagehelper.PageInfo(cs).getTotal();
        pageInfo.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", pageInfo);

        return "admin/listCategory";
    }

    @RequestMapping("admin_category_add")
    public String addCategory(Category category, HttpSession session, @RequestParam("image") MultipartFile image) throws IOException {
        categoryService.addCategory(category);
        if (image.getSize() > 0) {
            File file = new File(session.getServletContext().getRealPath("img/category"),
                    category.getId() + ".jpg");
            image.transferTo(file);
            return "redirect:/admin_category_list";
        }
        return "error";
    }

    @RequestMapping("admin_category_delete")
    public String deleteCategory(int id, HttpSession session) {
        categoryService.deleteCategory(id);
        File file = new File(session.getServletContext().getRealPath("img/category"),
                id + ".jpg");
        file.delete();

        return "redirect:/admin_category_list";
    }

    @RequestMapping("admin_category_edit")
    public String editCategory(int id, Model model) {
        Category category = categoryService.getCategory(id);
        model.addAttribute("category", category);

        return "admin/editCategory";

    }

    @RequestMapping("admin_category_update")
    public String updateCategory(Category category, HttpSession session, @RequestParam("categoryImage") MultipartFile editImage) throws IOException {
        categoryService.updateCategory(category);
        if (editImage.getSize() > 0) {
            File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imageFolder, category.getId() + ".jpg");
            editImage.transferTo(file);
            return "redirect:admin_category_list";
        }

        return "error";
    }
}
