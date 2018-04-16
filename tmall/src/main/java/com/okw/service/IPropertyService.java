package com.okw.service;

import com.okw.pojo.Property;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IPropertyService {
    List<Property> listProperty(int cid);

    void addProperty(Property property);

    void deleteProperty(int id);

    Property getProperty(int id);

    void updateProperty(Property property);
}
