package com.hazrat.quizapp.controller;

import com.hazrat.quizapp.Question;
import com.hazrat.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("/{id}")
    public Optional<Question> getQuestionsById(@PathVariable int id){
        return questionService.getQuestionsById(id);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);

    }

    @DeleteMapping ("/{id}")
    public String deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);

    }

    @PutMapping ("/{id}")
    public String updateQuestion(@PathVariable int id,@RequestBody Question question){
         questionService.updateQuestion( question);
         return "updated";

    }
}
