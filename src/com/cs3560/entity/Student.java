package com.cs3560.entity;


public class Student {

    /**
     * 
     */
    private String StudentID;


    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public Student() {
    }

    public Student(String studentID) {
        StudentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentID='" + StudentID + '\'' +
                '}';
    }
}
