package service;

import org.springframework.beans.factory.annotation.Autowired;
import pojo.Answer;

import java.util.List;

public interface AnswerService {


    List<Answer> findAll(int rid);

    int addAns(Answer answer);

    int delAns(int id);
}
