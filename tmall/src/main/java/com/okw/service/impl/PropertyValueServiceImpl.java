package com.okw.service.impl;

import com.okw.mapper.PropertyValueMapper;
import com.okw.pojo.Product;
import com.okw.pojo.Property;
import com.okw.pojo.PropertyValue;
import com.okw.pojo.PropertyValueExample;
import com.okw.service.IPropertyService;
import com.okw.service.IPropertyValueService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("propertyValueService")
public class PropertyValueServiceImpl implements IPropertyValueService {
    @Autowired
    private PropertyValueMapper propertyValueMapper;

    @Autowired
    @Qualifier("propertyService")
    private IPropertyService propertyService;
    @Override
    public void initPropertyValue(Product product) {
        List<Property> properties = propertyService.listProperty(product.getCid());
        for (Property property : properties) {
            PropertyValue propertyValue = getPropertyValue(property.getId(), product.getId());
            if (propertyValue == null) {
                PropertyValue value = new PropertyValue();
                value.setPid(product.getId());
                value.setPtid(property.getId());
                propertyValueMapper.insertSelective(value);

            }
        }

    }

    @Override
    public void updatePropertyValue(PropertyValue propertyValue) {
        propertyValueMapper.updateByPrimaryKeySelective(propertyValue);
    }

    @Override
    public PropertyValue getPropertyValue(int ptid, int pid) {
        PropertyValueExample example=new PropertyValueExample();
        example.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
        example.setOrderByClause("id desc");
        List<PropertyValue>propertyValues=propertyValueMapper.selectByExample(example);
        if (propertyValues.isEmpty()) return null;

        return propertyValues.get(0);
    }

    @Override
    public List<PropertyValue> listPropertyValue(int pid) {
        PropertyValueExample example=new PropertyValueExample();
        example.createCriteria().andPidEqualTo(pid);
        List<PropertyValue> propertyValues = propertyValueMapper.selectByExample(example);
        for (PropertyValue propertyValue : propertyValues) {
            Property property=propertyService.getProperty(propertyValue.getPtid());
            propertyValue.setProperty(property);
        }

        return propertyValues;
    }
}
