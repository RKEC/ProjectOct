package org.example;

import java.util.ArrayList;

public class Student {
    private String studentID;
    private int[] codes;
    private int[] grades;

    public Student(String studentID, int[] codes, int[] grades) {
        this.studentID = studentID;
        this.codes = codes;
        this.grades = grades;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int[] getCodes() {
        return codes;
    }

    public void setCodes(int[] codes) {
        this.codes = codes;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }
}