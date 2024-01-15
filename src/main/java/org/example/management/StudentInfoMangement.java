package org.example.management;

import org.example.model.Student;
import org.example.model.Subject;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StudentInfoMangement {
    int startIdIndex=0;
    Scanner sc = new Scanner(System.in);
    Student student;
    HashMap<Student, List<Subject>> studentList;
    SubjectInfoManagement subjectInfoManagement;

    public StudentInfoMangement() {
        studentList =new HashMap<>();
    }
    public void addStudent(){
        System.out.println("수강생 등록을 시작합니다.");
        System.out.println("수강생의 이름을 입력하세요");
        String studentName = sc.nextLine();
        student = new Student(++startIdIndex,studentName);
        System.out.println("=====수강할 과목을 입력해주세요=====");
        System.out.println("필수과목은 3개이상 선택과목은 2개 이상 선택해주세요");
        System.out.println("[필수] 1.수학 2.국어 3.영어 4.역사");
        System.out.println("[선택] 5.체육 6.음악 7.미술 8.제2외국어");
        System.out.println("***수강신청을 모두 완료하시고 0을 눌러서 종료해주세요***");
        subjectInfoManagement = new SubjectInfoManagement();
        List<Subject> subjects = subjectInfoManagement.addSubject();
        studentList.put(student,subjects);
    }
    public Student getStudentId(int id) {
        for(Student i : studentList.keySet()){
            if(id == i.getStudentID()){
                return i;
            }
        }
        return null;
    }
    public List<Subject> getSubjectList(Student s) {
        return studentList.get(s);
    }

}
