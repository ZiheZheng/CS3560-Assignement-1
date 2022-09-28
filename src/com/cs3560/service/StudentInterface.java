package com.cs3560.service;

import com.cs3560.entity.Choice;
import com.cs3560.entity.Question;

import java.util.List;
import java.util.Map;

public interface StudentInterface {

    /**
     * randomly generate n student
     * @param n
     */
    void randomStudent(int n);

    /**
     * randomly answer question
     * @param question
     * @return
     */
    Map<Character, Integer> randomAnswerQuestion(Question question);



}
