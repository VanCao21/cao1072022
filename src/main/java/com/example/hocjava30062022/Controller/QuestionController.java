package com.example.hocjava30062022.Controller;

import com.example.hocjava30062022.Model.Answer;
import com.example.hocjava30062022.Model.Question;
import com.example.hocjava30062022.Reponsitory.QuestionReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionReponsitory questionReponsitory;
    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(questionReponsitory.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(questionReponsitory.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Question question) {
        return new ResponseEntity(questionReponsitory.save(question), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        questionReponsitory.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Question question) {
        Optional<Question> oldAnswer = questionReponsitory.findById(id);
        if (!oldAnswer.isPresent()) {
            return new ResponseEntity(HttpStatus.OK);
        }
        question.setId(id);
        questionReponsitory.save(question);
        return new ResponseEntity(HttpStatus.OK);
    }
}
