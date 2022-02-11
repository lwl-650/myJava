package dao;

import org.apache.ibatis.annotations.Mapper;
import pojo.Answer;

import java.util.List;

@Mapper
public interface AnswerMapper {

    List<Answer> findAll(int rid);

    int addAns(Answer answer);

    int delAns(int id);
}
