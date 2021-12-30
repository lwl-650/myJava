package service;

import pojo.GoUrl;

import java.util.List;

public interface GoUrlService {
    /**
     *
     * @return
     */
    List<GoUrl> findAllUrl();

    /**
     *
     * @param goUrl
     * @return
     */
    int addUrl(GoUrl goUrl);

    /**
     *
     * @param id
     * @return
     */
    int delUrl(int id);
}
