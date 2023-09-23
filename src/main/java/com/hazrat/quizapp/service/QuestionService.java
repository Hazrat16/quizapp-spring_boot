package com.hazrat.quizapp.service;

import com.hazrat.quizapp.model.Question;
import com.hazrat.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity< List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {

        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public Optional<Question> getQuestionsById(int id) {
        return questionDao.findById(id);
    }
    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);

        try {
            return new ResponseEntity<> ("Success",HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        questionDao.deleteById(id);

        try {
            return new ResponseEntity<> ("Deleted",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> updateQuestion( Question question) {
        questionDao.save(question);

        try {
            return new ResponseEntity<> ("Updated",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);
    }
}
