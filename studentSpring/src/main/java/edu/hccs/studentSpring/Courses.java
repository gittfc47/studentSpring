package edu.hccs.studentSpring;

import java.io.IOException;
import java.util.List;
public class Courses {
    private List<Course> courses;

    public Courses() {
    }

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public double getAve() throws IOException {
        double total = 0;
        for (int i=0; i<courses.size(); i++) {
            Course course = courses.get(i);
            String grade = course.getGrade();
            double grd = course.grdValue(grade);
            total += grd;
        }
        double ave = total/courses.size();
        return ave;
    }
}
