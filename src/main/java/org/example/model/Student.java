package org.example.model;

public class Student {
    private int studentID;
    private String studentName;
    public Student(int studentID,String name) {
        this.studentID = studentID;
        this.studentName = name;
    }
    public String getName(){
        return studentName;
    }
    public int getStudentID(){
        return studentID;
    }

    @Override
    public String toString() {
        return "학생 ID: " + studentID + " 학생 이름: " + studentName;
    }
}
