package com.hazrat.quizapp.service;

import com.hazrat.quizapp.Question;
import com.hazrat.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
       return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public Optional<Question> getQuestionsById(int id) {
        return questionDao.findById(id);
    }
    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Success";
    }

    public String deleteQuestion(int id) {
        questionDao.deleteById(id);
        return "deleted";
    }


    public String updateQuestion( Question question) {
        questionDao.save(question);
        return "updated";
    }
}
