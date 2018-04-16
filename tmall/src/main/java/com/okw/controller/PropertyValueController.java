package com.okw.controller;

import com.okw.pojo.Product;
import com.okw.pojo.PropertyValue;
import com.okw.service.IProductService;
import com.okw.service.IPropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PropertyValueController {
    @Autowired
    @Qualifier("propertyValueService")
    private IPropertyValueService propertyValueService;

    @Autowired
    @Qualifier("productService")
    private IProductService productService;


    @RequestMapping("admin_propertyValue_edit")
    public String editPropertyValue(Model model, int pid) {
        Product product = productService.getProduct(pid);
        propertyValueService.initPropertyValue(product);
        List<PropertyValue> propertyValues = propertyValueService.listPropertyValue(pid);

        model.addAttribute("product", product);
        model.addAttribute("propertyValues", propertyValues);


        return "admin/editPropertyValue";
    }

    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String updatePropertyValue(PropertyValue value){
        propertyValueService.updatePropertyValue(value);
        return "ok";
    }
}
