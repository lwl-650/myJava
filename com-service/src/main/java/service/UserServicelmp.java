package service;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

import java.util.List;

@Service
public class UserServicelmp implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return  userMapper.findAll();
    }
}
