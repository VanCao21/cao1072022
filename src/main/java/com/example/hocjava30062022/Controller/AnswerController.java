package com.example.hocjava30062022.Controller;

import com.example.hocjava30062022.Model.Answer;
import com.example.hocjava30062022.Model.Question;
import com.example.hocjava30062022.Reponsitory.AnswerReponsitory;
import com.example.hocjava30062022.Reponsitory.QuestionReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    AnswerReponsitory answerReponsitory;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(answerReponsitory.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(answerReponsitory.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Answer answer) {
        return new ResponseEntity(answerReponsitory.save(answer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        answerReponsitory.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Answer answer) {
        Optional<Answer> oldAnswer = answerReponsitory.findById(id);
        if (!oldAnswer.isPresent()) {
            return new ResponseEntity(HttpStatus.OK);
        }
        answer.setId(id);
        answerReponsitory.save(answer);
        return new ResponseEntity(HttpStatus.OK);
    }
}
