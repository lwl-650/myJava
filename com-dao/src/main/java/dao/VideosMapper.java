package dao;

import org.apache.ibatis.annotations.Mapper;
import pojo.Videos;

import java.util.List;

@Mapper
public interface VideosMapper {

    List<Videos> findViall();

    int addVi(Videos videos);

    int delVi(int vid);

   Videos findById(int vid);

    Videos findByVid(Integer vid);
}
