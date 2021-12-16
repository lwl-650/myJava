package service;

import dao.SsqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Ssq;

import java.util.List;

@Service
public class SsqServiceImp implements SsqService {

    @Autowired
    private SsqMapper ssqMapper;

    /**
     *
     * @param ssq
     * @return
     */
    public int setSsq(Ssq ssq) {
        return ssqMapper.setSsq(ssq);
    }

    /**
     *
     * @return
     */
    public List<Ssq> getOneSsq() {
        return ssqMapper.getOneSsq();
    }

    /**
     *
     * @return
     */
    public Integer getRe(int ssqId) {
        return ssqMapper.getRe(ssqId);
    }
}
