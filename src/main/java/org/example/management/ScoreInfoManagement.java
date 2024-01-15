package org.example.management;

import org.example.model.Score;
import org.example.model.Subject;
import org.example.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ScoreInfoManagement {
    Scanner sc = new Scanner(System.in);
    List<Subject> subjectList;

    HashMap<Student, HashMap<Subject, List<Score>>> scoreManagementList;
    private Score score;
    private Subject subject;
    private String subjectType;


    public ScoreInfoManagement() {
        scoreManagementList = new HashMap<>();

    }

    public void addScore(StudentInfoMangement studentInfoMangement) {
        while (true) {
            System.out.println("점수와 회차를 추가하실 학생의 ID를 입력하세요");
            int choiceNum = sc.nextInt();
            sc.nextLine();
            Student student = studentInfoMangement.getStudentId(choiceNum);
            HashMap<Subject, List<Score>> subjectAndScore = scoreManagementList.computeIfAbsent(student, k -> new HashMap<>());
            subjectList = studentInfoMangement.getSubjectList(student);
            List<Score> scoreList = subjectAndScore.computeIfAbsent(subject, k ->new ArrayList<>());
            for (Subject i : subjectList) {
                System.out.println(i);
            }
            System.out.println("어떤 과목에 점수와 회차를 추가하시겠습니까?");
            System.out.println("[필수] 1.수학 2.국어 3.영어 4.역사");
            System.out.println("[선택] 5.체육 6.음악 7.미술 8.제2외국어");
            String subjectChoiceName = sc.nextLine();
            for (Subject i : subjectList) {
                if (i.getName().equals(subjectChoiceName)) {
                    subject = i;
                    subjectType = i.getSubjectType();
                    System.out.println(subject + "를 선택하셨습니다.");
                }
            }
            System.out.println("회차를 입력하세요");
            int roundChoiceNum = sc.nextInt();
            sc.nextLine();
            if(roundChoiceNum<0||roundChoiceNum>10){
                System.out.println("라운드는 1 ~ 10 까지 입력 가능합니다.");
                continue;
            }
            if(checkRound(studentInfoMangement.getStudentId(choiceNum),subject,roundChoiceNum)){
                continue;
            }
            else{
                try {
                    System.out.println("점수를 입력하세요");
                    int scoreInput = sc.nextInt();
                    score = new Score(scoreInput, roundChoiceNum,subjectType);
                    scoreList.add(score);
                    subjectAndScore.put(subject, scoreList);
                    scoreManagementList.put(studentInfoMangement.getStudentId(choiceNum), subjectAndScore);
                    System.out.println(studentInfoMangement.getStudentId(choiceNum).getName() + "학생의 " + subject.getName() + " 과목의" + roundChoiceNum + "회차 점수가 등록되었습니다.");
                    break;
                }
                catch (Exception e){
                    System.out.println(e + "오류");
                }
            }
        }
    }

    public HashMap<Student, HashMap<Subject, List<Score>>> getScoreManagementList() {
        return scoreManagementList;
    }

    public boolean checkRound(Student student, Subject subject, int round) {
        if (scoreManagementList.containsKey(student)) {
            HashMap<Subject,List<Score>> studentStoreList = scoreManagementList.get(student);
            if(studentStoreList != null && studentStoreList.containsKey(subject)) {
                List<Score> scores = studentStoreList.get(subject);
                for(Score s : scores){
                    if(s.getRound()==round){
                        System.out.println("라운드가 중복됐습니다.");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}