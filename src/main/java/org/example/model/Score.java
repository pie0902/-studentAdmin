package org.example.model;

public class Score {
    private int scoreNum;
    private int round;
    private String grade;
    private String type;

    public Score(int scoreNum, int round, String type) {
        this.scoreNum = scoreNum;
        this.round = round;
        this.type = type;
        setGrade(scoreNum, type);
    }

    public void setGrade(int scoreNum, String type) {
        if (type.equals("필수")) {
            if (scoreNum >= 95 && scoreNum < 100) {
                this.grade = "A";
            } else if (scoreNum >= 90 && scoreNum < 95) {
                this.grade = "B";
            } else if (scoreNum >= 80 && scoreNum < 90) {
                this.grade = "C";
            } else if (scoreNum >= 70 && scoreNum < 80) {
                this.grade = "D";
            } else if (scoreNum >= 60 && scoreNum < 70) {
                this.grade = "F";
            }
        } else if (type.equals("선택")) {
            if (scoreNum >= 90 && scoreNum < 100) {
                this.grade = "A";
            } else if (scoreNum >= 80 && scoreNum < 90) {
                this.grade = "B";
            } else if (scoreNum >= 70 && scoreNum < 80) {
                this.grade = "C";
            } else if (scoreNum >= 60 && scoreNum < 70) {
                this.grade = "D";
            } else if (scoreNum >= 50 && scoreNum < 60) {
                this.grade = "F";
            }
        }
    }

    public int getRound() {
        return round;
    }

    public int getScoreNum() {
        return scoreNum;
    }
    public String getGrade(){
        return grade;
    }
}
