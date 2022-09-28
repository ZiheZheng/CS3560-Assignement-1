package com.cs3560.entity;

import java.util.List;

public class Question {

    /**
     * The ID of question
     */
    private int ID;

    /**
     * Description of the question
     */
    private String title;

    /**
     * Description of the option
     */
    private List<Choice> choices;


    /**
     * The type of question
     * Example: 1. single choice && 2. multiple choice
     */
    private int type;

    /**
     * getter and setter function
     * @return
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * default constructor
     */
    public Question(){

    }

    /**
     * Consctructor for ID, title, List<choice>, type
     * @param ID
     * @param title
     * @param choices
     * @param type
     */
    public Question(int ID, String title, List<Choice> choices, int type) {
        this.ID = ID;
        this.title = title;
        this.choices = choices;
        this.type = type;
    }




}
