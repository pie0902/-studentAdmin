package org.example.model;

public class Subject {
    private String subjectName;
    private String subjectType;

    //필수
    public Subject(int subjectNum) {
        initializeSubject(subjectNum);
    }

    private void initializeSubject(int subjectNum) {
        switch (subjectNum) {
            case 0:
                System.out.println("수강신청을 완료했습니다.");
            case 1:
                this.subjectName = "수학";
                this.subjectType = "필수";
                break;
            case 2:
                this.subjectName = "국어";
                this.subjectType = "필수";
                break;
            case 3:
                this.subjectName = "영어";
                this.subjectType = "필수";
                break;
            case 4:
                this.subjectName = "역사";
                this.subjectType = "필수";
                break;
            case 5:
                this.subjectName = "체육";
                this.subjectType = "선택";
                break;
            case 6:
                this.subjectName = "음악";
                this.subjectType = "선택";
                break;
            case 7:
                this.subjectName = "미술";
                this.subjectType = "선택";
                break;
            case 8:
                this.subjectName = "제2외국어";
                this.subjectType = "선택";
                break;
            default:
                System.out.println("1번부터 8번까지만 선택 가능합니다.");
                break;
        }
    }
    public String getName(){
        return subjectName;
    }
    public String getSubjectType(){
        return subjectType;
    }
    @Override
    public String toString() {
        return "타입: "+subjectType + ", 과목 이름: " + subjectName + "\n";
    }
}

