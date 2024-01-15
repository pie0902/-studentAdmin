package org.example.management;

import org.example.model.Subject;

import java.util.*;

public class SubjectInfoManagement {
    Scanner sc = new Scanner(System.in);
    List<Subject> subjectList;
    Subject subject;
    Set<Integer> chooseHistory;
    int choiceNum;
    int cnt1 = 0;
    int cnt2 = 0;

    public SubjectInfoManagement() {
        subjectList = new ArrayList<>();
        chooseHistory = new HashSet<>();
    }


    public List<Subject> addSubject() {
        while (true) {
            choiceNum = sc.nextInt();
            sc.nextLine();
            if (choiceNum == 0) {
                if (cnt1 >= 3 && cnt2 >= 2) {
                    return subjectList;
                } else {
                    System.out.println("필수과목 " + cnt1 + "개, 선택과목 " + cnt2 + "개 선택하셨습니다.");
                    System.out.println("필수과목은 3개이상, 선택과목은 2개 이상 선택해주세요.");
                    continue;
                }
            }
            if (choiceNum < 1 && choiceNum > 8) {
                System.out.println("1번부터 8번까지만 선택 가능합니다.");
            }
            if (!chooseHistory.add(choiceNum)) {
                System.out.println("중복된 선택입니다.");
                continue;
            }
            subject = new Subject(choiceNum);
            subjectList.add(subject);
            if (choiceNum < 5) {
                System.out.println(subject.toString() + " 추가되었습니다.");
                cnt1++;
            } else {
                System.out.println(subject.toString() + " 추가되었습니다.");
                cnt2++;
            }


        }
    }

}
