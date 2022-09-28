package com.cs3560.service;

import com.cs3560.entity.Choice;
import com.cs3560.entity.Question;

import java.util.List;

public interface QuestionInterface {

    /**
     * create multiple question for student answer
     * @return
     */
    int createQuestions();

    /**
     * return all the question to student answer
     * @return
     */
    List<Question> getAllQuestion();

}
