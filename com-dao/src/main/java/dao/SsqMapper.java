package dao;

import org.apache.ibatis.annotations.Mapper;
import pojo.Ssq;

import java.util.List;

@Mapper
public interface SsqMapper {

    /**
     *
     * @param ssq
     * @return
     */
    int setSsq(Ssq ssq);

    /**
     *
     * @return
     */
    List<Ssq> getOneSsq();

    /**
     *
     * @return
     */
    Integer getRe(int ssqId);
}
