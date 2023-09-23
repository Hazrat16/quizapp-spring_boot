package com.hazrat.quizapp.controller;

import com.hazrat.quizapp.model.Question;
import com.hazrat.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity< List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity< List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("/{id}")
    public Optional<Question> getQuestionsById(@PathVariable int id){
        return questionService.getQuestionsById(id);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);

    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);

    }

    @PutMapping ("/{id}")
    public String updateQuestion(@PathVariable int id, @RequestBody Question question){
         questionService.updateQuestion( question);
         return "updated";

    }

}
