package edu.hccs.studentSpring;

import org.springframework.stereotype.Component;

@Component
public class Course {
    private String courseNo;
    private String grade;
    private int creditHours;

    public Course() {
    }

    public Course(String courseNo, String grade, int creditHours) {
        this.courseNo = courseNo;
        this.grade = grade;
        this.creditHours = creditHours;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public double grdValue(String grade){
        if (grade.equals("A") )
            return (double)4;
        else if (grade.equals("B"))
            return (double)3;
        else if (grade.equals("C"))
            return (double)2;
        else if (grade.equals("D"))
            return (double)1;
        else
            return 0;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseNo='" + courseNo + '\'' +
                ", grade='" + grade + '\'' +
                ", creditHours=" + creditHours +
                '}';
    }

}

