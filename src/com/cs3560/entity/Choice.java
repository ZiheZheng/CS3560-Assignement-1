package com.cs3560.entity;

public class Choice {

    /**
     * option that you can choice
     * Example: A. ...
     *          B. ...
     *          C. ...
     *          D. ...
     */
    private char choiceName;

    /**
     * description of a choice
     */
    private String singleQuestion;

    /**
     * default constructor
     */
    public Choice() {
    }

    /**
     * constructor for choiceName and singleQuestion
     * @param choiceName
     * @param singleQuestion
     */
    public Choice(char choiceName, String singleQuestion) {
        this.choiceName = choiceName;
        this.singleQuestion = singleQuestion;
    }

    /**
     * getter and setter function
     * @return
     */
    public char getChoiceName() {
        return choiceName;
    }

    public void setChoiceName(char choiceName) {
        this.choiceName = choiceName;
    }

    public String getSingleQuestion() {
        return singleQuestion;
    }

    public void setSingleQuestion(String singleQuestion) {
        this.singleQuestion = singleQuestion;
    }
}
