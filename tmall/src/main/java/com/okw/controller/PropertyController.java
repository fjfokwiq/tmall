package com.okw.controller;

import com.github.pagehelper.PageHelper;
import com.okw.pojo.Category;
import com.okw.pojo.Property;
import com.okw.service.ICategoryService;
import com.okw.service.IPropertyService;
import com.okw.until.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class PropertyController {
    @Autowired
    @Qualifier("serviceImpl")
    ICategoryService categoryService;
    @Autowired
    @Qualifier("propertyService")
    IPropertyService propertyService;

    @RequestMapping("admin_property_list")
    public String listProperty(int cid, Model model, PageInfo propertyPageInfo) {
        Category category = categoryService.getCategory(cid);
        PageHelper.offsetPage(propertyPageInfo.getOffset(), propertyPageInfo.getCount());
        List<Property> properties = propertyService.listProperty(cid);
        int total = (int) new com.github.pagehelper.PageInfo<>().getTotal();
        propertyPageInfo.setTotal(total);
        propertyPageInfo.setParam("&cid=" + category.getId());

        model.addAttribute("category", category);
        model.addAttribute("properties", properties);
        model.addAttribute("pageInfo", propertyPageInfo);


        return "admin/listProperty";
    }

    @RequestMapping("admin_property_add")
    public String addProperty(Model model, Property property) {
        propertyService.addProperty(property);
        return "redirect:admin_property_list?cid=" + property.getCid();

    }

    @RequestMapping("admin_property_delete")
    public String deleteProperty(int id) {
        Property property = propertyService.getProperty(id);
        propertyService.deleteProperty(id);
        return "redirect:admin_property_list?cid=" + property.getCid();
    }

    @RequestMapping("admin_property_edit")
    public String editProperty(Model model, int id) {
        Property property = propertyService.getProperty(id);
        Category category = categoryService.getCategory(property.getCid());
        property.setCategory(category);
        model.addAttribute("propertity", property);
        return "admin/editProperty";
    }

    @RequestMapping("admin_property_update")
    public String updateProperty(Property property) {
        propertyService.updateProperty(property);
        return "redirect:admin_property_list?cid=" + property.getCid();
    }
}
