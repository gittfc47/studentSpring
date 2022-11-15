package edu.hccs.studentSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Student {
    private String first_name;
    private String email;
    private String gender;
    //   @Autowired
    List<Course> courses;

    public Student() {
    }

    public Student(String first_name, String email, String gender, List<Course> courses) {
        this.first_name = first_name;
        this.email = email;
        this.gender = gender;
        this.courses = courses;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "first_name='" + first_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", courses=" + courses +
                '}' + "\n";
    }
}
