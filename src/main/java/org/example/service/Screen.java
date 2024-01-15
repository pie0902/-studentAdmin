package org.example.service;

import org.example.management.ScoreInfoManagement;
import org.example.management.StudentInfoMangement;
import org.example.model.Score;
import org.example.model.Student;
import org.example.model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Screen {

    Scanner sc = new Scanner(System.in);
    int choiceNum;
    //학생 객체
    HashMap<Student, List<Subject>> sm;
    List<Subject> subjectList;
    Subject subject;
    StudentInfoMangement studentInfoMangement;
    ScoreInfoManagement scoreInfoManagement;
    HashMap<Student, HashMap<Subject, List<Score>>> scoreManagementList;
    //과목 리스트 객체
    public Screen() {
        sm = new HashMap<>();
        studentInfoMangement = new StudentInfoMangement();
        scoreInfoManagement = new ScoreInfoManagement();
        subjectList = new ArrayList<>();
    }

    public void startScreen() {
        while (true) {
            System.out.println("수강생 관리 프로그램을 시작합니다.");
            System.out.println("1.수강생 관리");
            System.out.println("2.수강생 점수관리");
            System.out.println("3.종료");
            choiceNum = sc.nextInt();
            sc.nextLine();
            switch (choiceNum) {
                case 1 -> startStudentManagement();
                case 2 -> studentScoreManger();
                case 3 -> System.exit(0);
                default -> System.out.println("올바른 번호를 입력해주세요");
            }
        }
    }

    public void startStudentManagement() {
        System.out.println("1.수강생 등록");
        System.out.println("2.수강생 조회");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1 -> addStudentList();
            case 2 -> getStudentList();
        }
    }

    public void studentScoreManger() {
        System.out.println("1.수강생 과목별 점수와 회차 등록");
        System.out.println("2.수강생 과목별 회차 점수 조회");
        int choiceNum = sc.nextInt();
        sc.nextLine();
        switch (choiceNum) {
            case 1 -> addStudentScore();
            case 2 -> getStudentScore();
            default -> System.out.println("올바른 번호를 입력해주세요");
        }

    }

    public void addStudentList() {
        studentInfoMangement.addStudent();
    }

    public void getStudentList() {
        try {
            System.out.println("조회하실 수강생의 ID를 입력해주세요");
            int choiceId = sc.nextInt();
            Student student = studentInfoMangement.getStudentId(choiceId);
            scoreManagementList = scoreInfoManagement.getScoreManagementList();
            if (student != null) {
                System.out.println("학생 정보: " + student);
                subjectList = studentInfoMangement.getSubjectList(student);
                for (Subject i : subjectList) {
                    System.out.println(i);
                }
            }
        }catch(Exception e){
            System.out.println(e + "오류");
        }
    }


    public void addStudentScore() {
        scoreInfoManagement.addScore(studentInfoMangement);
    }
    public void getStudentScore(){
        System.out.println("조회하실 수강생의 id를 입력해주세요");
        int choiceId = sc.nextInt();
        sc.nextLine();
        System.out.println("조회하실 과목을 입력하세요");
        Student student = studentInfoMangement.getStudentId(choiceId);
        scoreManagementList = scoreInfoManagement.getScoreManagementList();
        subjectList = studentInfoMangement.getSubjectList(student);
        String subjectName = sc.nextLine();
        for(Subject i : subjectList){
            if(i.getName().equals(subjectName)){
                 subject = i;
            }
        }
        if(subject == null){
            System.out.println("해당 과목을 찾을 수 없습니다.");
        }
        else{
            System.out.println(subject + "를 선택하셨습니다.");
        }
        HashMap<Subject,List<Score>> subjectScore = scoreInfoManagement.getScoreManagementList().get(student);
        System.out.println("몇 회차를 조회하시겠습니까?");
        int num = sc.nextInt();
        List<Score> scoreList = subjectScore.get(subject);
        Score answer = scoreList.get(num-1);
        System.out.println(subjectName + "과목의 " + num + "회차의 점수는 "+ answer.getScoreNum()+ "점 입니다.");
        System.out.println("등급은 "+ answer.getGrade() + " 입니다.");
    }

}
