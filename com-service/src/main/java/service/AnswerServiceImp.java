package service;

import dao.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import pojo.Answer;

import java.util.List;

@Service
public class AnswerServiceImp implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;


    public List<Answer> findAll(int rid) {
        return answerMapper.findAll(rid);
    }

    public int addAns(Answer answer) {
        return answerMapper.addAns(answer);
    }

    public int delAns(int id) {
        return answerMapper.delAns(id);
    }
}
