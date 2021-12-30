package service;

import pojo.StuUrl;

import java.util.List;

public interface StuUrlService {
    /**
     *
     * @return
     */
    List<StuUrl> findSall();

    /**
     *
     * @param stuUrl
     * @return
     */
    int addSitem(StuUrl stuUrl);

    /**
     *
     * @param sid
     * @return
     */
    int delSitem(int sid);
}
