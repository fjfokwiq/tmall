package com.okw.service.impl;

import com.okw.mapper.PropertyMapper;
import com.okw.pojo.Property;
import com.okw.pojo.PropertyExample;
import com.okw.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("propertyService")
public class PropertyServiceImpl implements IPropertyService {
    @Autowired
    private PropertyMapper propertyMapper;
    @Override
    public List<Property> listProperty(int cid) {
        PropertyExample propertyExample=new PropertyExample();
        propertyExample.createCriteria().andCidEqualTo(cid);
        propertyExample.setOrderByClause("id desc");

        return propertyMapper.selectByExample(propertyExample);
    }

    @Override
    public void addProperty(Property property) {
        propertyMapper.insertSelective(property);
    }

    @Override
    public void deleteProperty(int id) {
        propertyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Property getProperty(int id) {
        return propertyMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateProperty(Property property) {
        propertyMapper.updateByPrimaryKeySelective(property);
    }
}
