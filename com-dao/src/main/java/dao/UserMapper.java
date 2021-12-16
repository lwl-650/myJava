package dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     *
     * @return
     */
    List<User> findAll();

    /**
     *
     * @param uesrname
     * @return
     */
    User login(@Param("username") String uesrname);
}
