package dao;

import org.apache.ibatis.annotations.Mapper;
import pojo.StuUrl;

import java.util.List;

@Mapper
public interface StuUrlMapper {

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
