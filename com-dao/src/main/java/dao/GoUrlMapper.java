package dao;

import org.apache.ibatis.annotations.Mapper;
import pojo.GoUrl;

import java.util.List;

@Mapper
public interface GoUrlMapper {

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
