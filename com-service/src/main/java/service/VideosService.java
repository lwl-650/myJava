package service;

import pojo.Videos;

import java.util.List;

public interface VideosService {

    List<Videos> findViall();

    int addVi(Videos videos);

    int delVi(int vid);

    Videos findById(int vid);

    Videos findByVid(int vid);


}
