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

    /**
     *
     * @return
     */
    public List<User> findAll() {
        return  userMapper.findAll();
    }

    /**
     *
     * @param uesrname
     * @param password
     * @return
     */
    public boolean login(String uesrname,String password) {
        User user=userMapper.login(uesrname);
      return    user.getPassword().equals(password)? true:false;

//        return true;
    }

    public User loginByOpenid(String openid) {
        return userMapper.loginByOpenid(openid);
    }

    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    public Integer  findThis(String openid) {
        return userMapper.findThis(openid);
    }
}
