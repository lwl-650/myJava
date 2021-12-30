package service;

import dao.GoUrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.GoUrl;

import java.util.List;

@Service
public class GoUrlServiceImp implements GoUrlService {
    @Autowired
    private GoUrlMapper goUrlMapper;

    /**
     *
     * @return
     */
    public List<GoUrl> findAllUrl() {
        return goUrlMapper.findAllUrl();
    }

    /**
     *
     * @param goUrl
     * @return
     */
    public int addUrl(GoUrl goUrl) {
        return goUrlMapper.addUrl(goUrl);
    }

    /**
     *
     * @param id
     * @return
     */
    public int delUrl(int id) {
        return goUrlMapper.delUrl(id);
    }
}
