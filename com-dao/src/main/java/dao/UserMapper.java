package dao;


import org.apache.ibatis.annotations.Mapper;
import pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();
}
