package com.stevengoh.academic;

import com.stevengoh.academic.course.Course;
import com.stevengoh.academic.course.CourseRepository;
import com.stevengoh.academic.student.Student;
import com.stevengoh.academic.student.StudentRepository;
import com.stevengoh.academic.term.Term;
import com.stevengoh.academic.term.TermRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@SpringBootApplication
public class AcademicApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicApplication.class, args);
	}

	@Bean
	public CommandLineRunner initStudent (StudentRepository studentRepository) {
		return args -> {
			Student student1 = new Student("Steven", "Gozali", LocalDate.of(2001, Month.JUNE, 10), "stevengozali23@gmail.com", "$2a$10$YjMwEb65EFxmI.5TdIRBMet32JGGkKOmFZwYOUh.owXSsuRhN7VnS");
			Student student2 = new Student("Steven", "Apaa", LocalDate.of(2001, Month.JUNE, 10), "stevengozali22@gmail.com", "$2a$10$YjMwEb65EFxmI.5TdIRBMet32JGGkKOmFZwYOUh.owXSsuRhN7VnS");
			studentRepository.save(student1);
			studentRepository.save(student2);
		};
	}

	@Bean
	public CommandLineRunner initCourse (CourseRepository courseRepository) {
		return args -> {
			Course course1 = new Course("CRS-001", "Java Programming", "A Java Programming Course", true, 4);
			Course course2 = new Course("CRS-002", "React Programming", "A React Programming Course", true, 4);

			courseRepository.save(course1);
			courseRepository.save(course2);
		};
	}

	@Bean
	public CommandLineRunner initTerm (TermRepository termRepository) {
		return args -> {
			Term term = new Term("2023/2024", true);

			termRepository.save(term);
		};
	}
}