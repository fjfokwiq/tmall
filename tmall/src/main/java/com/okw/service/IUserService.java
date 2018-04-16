package com.okw.service;

import com.okw.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    List<User> listUser();

    User getUser(int id);

    void addUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

}
