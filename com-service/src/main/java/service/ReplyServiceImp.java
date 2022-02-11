package service;

import dao.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Reply;

import java.util.List;

@Service
public class ReplyServiceImp implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    /**
     *
     * @return
     */
    public List<Reply> findAllReply() {
        return replyMapper.findAllReply();
    }

    /**
     *
     * @param reply
     * @return
     */
    public int addReply(Reply reply) {
        return replyMapper.addReply(reply);
    }

    /**
     *
     * @param id
     * @return
     */
    public int delReply(int id) {
        return replyMapper.delReply(id);
    }

    public List<Reply> findReplyByVid(int vid) {
        return replyMapper.findReplyByVid(vid);
    }

    public List<Reply> findByIdPage(Integer vid, int pages, int num) {
        return replyMapper.findByIdPage(vid,pages,num);
    }
}
