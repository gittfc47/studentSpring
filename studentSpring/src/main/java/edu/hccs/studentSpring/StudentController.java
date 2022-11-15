package edu.hccs.studentSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    /***
     * http://localhost:8080/student/Aida
     * @param first_name
     * @return Student
     * @throws IOException
     */
    @GetMapping("/student/{first_name}")
    public Student  student(@PathVariable String first_name) throws IOException {
        System.out.println("search student by first_name : "+first_name);
        List<Student>  students = readData();
        for(Student student : students){
            if( student.getFirst_name().equalsIgnoreCase(first_name)){
                System.out.println("found student "+student);
                return student;
            }
        }
        System.out.println(" No student found for first_name "+first_name);
        return null;
    }

    //  http://localhost:8080/studentb?first_name=Aida&courseNo=CS
    @GetMapping("/studentb")
    public Student  student(@RequestParam String first_name, @RequestParam String courseNo) throws IOException {
        System.out.println("search Student by first_name : "+first_name+" courseNo : "+courseNo);
        List<Student>  students = readData();
        for(Student student : students){
            if( student.getFirst_name().equalsIgnoreCase(first_name) && student.getCourses().get(0).getCourseNo().equalsIgnoreCase(courseNo)){
                System.out.println("found student "+student);
                return student;
            }
        }
        System.out.println(" No student found for firstName "+first_name);
        return null;
    }

    /**
     *   URL :  http://localhost:8080/students
     * @return all students
     * @throws IOException
     */

    /***
     * Read the student.txt file
     * @return all the students
     * @throws IOException
     */
    @GetMapping("/students")
    public List<Student> readData() throws IOException {

        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        FileReader fileReader = new FileReader("C:\\Users\\TFCHEN\\Desktop\\Java 2438 Asignment\\StudentCourse.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //String header = bufferedReader.readLine(); // read the header
        String line = bufferedReader.readLine(); // read the first line

        while ( line != null) {
            String[] data = line.split(",");// split each read line by comma
            if (data.length<4) {
                Student student = new Student(data[0], data[1], data[2],null);
                students.add(student);
            }

            else {
                if (data[4] != "") {
                    Course course = new Course(data[3], data[4], Integer.parseInt(data[5]));
                    courses.add(course);
                }
                if (data[7] != "") {
                    Course course = new Course(data[6], data[7], Integer.parseInt(data[8]));
                    courses.add(course);
                }
                Student student = new Student(data[0], data[1], data[2], courses);
                students.add(student);
            }

            line = bufferedReader.readLine();

            courses = new ArrayList<>();
        }
        return students;
    }

    //@GetMapping("/average")
    public void showAve() throws IOException{
        List<Student>  students = readData();
        for(int i=0; i<students.size(); i++){
            Student student = students.get(i);
            if (student.getCourses() != null){
                //double total;
                List<Course> courses = student.getCourses();
                double total = 0;
                for (int j=0; j<courses.size(); j++) {
                    Course course = courses.get(j);
                    String grade = course.getGrade();
                    double grd = course.grdValue(grade);
                    total += grd;
                }
                double ave = total/courses.size();
                System.out.println(student.getFirst_name() + '\t' + ave);
            }
            else
                System.out.println(student.getFirst_name() + '\t' + "Haven't taken any course");
        }
    }




}


