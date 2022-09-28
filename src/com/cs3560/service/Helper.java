package com.cs3560.service;

import com.cs3560.entity.Choice;
import com.cs3560.entity.Question;

import java.util.*;

/**
 * Helper function
 *
 */
public class Helper {

    public static String convertNumToLetter(int studentAnswer){
        String str = "";

        if(studentAnswer == 0){
            str = "A";
        }else if(studentAnswer == 1){
            str = "B";
        }else if(studentAnswer == 2){
            str = "C";
        }else{
            str = "D";
        }

        return str;
    }

    /**
     * Find the unique random number
     * @param n
     * @return Hashset
     */
    public static HashSet<Integer> generateUniqueNum(int n) {

        Random random = new Random();
        HashSet hs = new HashSet();
        for (;;){
            int temp = random.nextInt(n);
            hs.add(temp);
            if(hs.size() == n) break;
        }

        return hs;

    }

    /**
     * Generate a question
     * @param id
     * @param title
     * @param type
     * @param choices
     * @return Question
     */

    public static Question generateQuestion(int id, String title, int type, List<Choice> choices){
        List<Choice> listChoices = new ArrayList<>();

        for (int i =0; i <choices.size(); i++){
            listChoices.add(choices.get(i));
        }

        return  new Question(id, title, listChoices, type);
    }

    /**
     * Generate multiple of question's choice
     * @param choiceName
     * @param singleQuestion
     * @return a list of Choice
     */
    public static List<Choice> generateChoice(char []choiceName, String []singleQuestion){
        if(choiceName== null || singleQuestion == null || choiceName.length != singleQuestion.length){
            throw new RuntimeException("Null elements");
        }

        List<Choice> list = new ArrayList<>();
        for (int i = 0; i < choiceName.length; i ++){
            Choice c = new Choice(choiceName[i], singleQuestion[i]);
            list.add(c);
        }
        return  list;
    }

}
