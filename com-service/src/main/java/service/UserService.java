package service;


import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface UserService {

    /**
     *
     * @return
     */
    List<User> findAll();

    /**
     *
     * @param uesrname
     * @param password
     * @return
     */
    boolean login(@Param("username") String uesrname,@Param("password") String password);
}
