package com.example.hocjava30062022.Reponsitory;

import com.example.hocjava30062022.Model.Answer;
import com.example.hocjava30062022.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerReponsitory  extends JpaRepository<Answer,Long> {
    List<Answer> findAllById(Long id);
}
