package com.okw.service;

import com.okw.pojo.Product;
import com.okw.pojo.PropertyValue;

import java.util.List;

public interface IPropertyValueService {
    void initPropertyValue(Product product);

    void updatePropertyValue(PropertyValue propertyValue);

    PropertyValue getPropertyValue(int ptid, int pid);

    List<PropertyValue> listPropertyValue(int pid);



}
