package service;

import dao.StuUrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.StuUrl;

import java.util.List;

@Service
public class StuUrlServiceImp implements  StuUrlService{
    @Autowired
    private StuUrlMapper stuUrlMapper;

    public List<StuUrl> findSall() {
        return stuUrlMapper.findSall();
    }

    public int addSitem(StuUrl stuUrl) {
        return stuUrlMapper.addSitem(stuUrl);
    }

    public int delSitem(int sid) {
        return stuUrlMapper.delSitem(sid);
    }
}
