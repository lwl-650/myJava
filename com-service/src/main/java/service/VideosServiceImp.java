package service;

import dao.VideosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Videos;

import java.util.List;

@Service
public class VideosServiceImp implements VideosService {
    @Autowired
    private VideosMapper videosMapper;

    public List<Videos> findViall() {
        return videosMapper.findViall();
    }

    public int addVi(Videos videos) {
        return 0;
    }

    public int delVi(int vid) {
        return 0;
    }

    public Videos findById(int vid) {
        return videosMapper.findById(vid);
    }

    public Videos findByVid(int vid) {
        return videosMapper.findByVid(vid);
    }
}
