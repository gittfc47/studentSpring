package edu.hccs.studentSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StudentSpringApplication {

	private static void extracted(ConfigurableApplicationContext context) throws IOException {

		StudentController studentController = context.getBean(StudentController.class);
		System.out.println(" students "+ studentController.readData());
		studentController.showAve();


	}

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(StudentSpringApplication.class, args);
		extracted(context);
	}

/**
 *  	public static void main(String[] args) {
 *		SpringApplication.run(StudentSpringApplication.class, args);
 *	}
*/

}
