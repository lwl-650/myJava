package service;


import pojo.Ssq;

import java.util.List;


public interface SsqService {
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
