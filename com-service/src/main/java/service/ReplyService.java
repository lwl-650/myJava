package service;

import org.apache.ibatis.annotations.Param;
import pojo.Reply;

import java.util.List;

public interface ReplyService {
    /**
     *
     * @return
     */
    List<Reply> findAllReply();

    /**
     *
     * @param reply
     * @return
     */
    int addReply(Reply reply);

    /**\
     *
     * @param id
     * @return
     */
    int delReply(int id);

    List<Reply> findReplyByVid(int vid);

    List<Reply> findByIdPage(@Param("vid") Integer vid, @Param("pages") int pages, @Param("num") int num);
}
