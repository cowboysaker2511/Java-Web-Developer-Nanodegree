package com.example.CSV_Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
@SpringBootApplication
public class CsvDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvDemoApplication.class, args);

		try {
			//Create new students objects
			Student student1 = new Student(1, "Ahmed", "Mohamed", "M", 25);
			Student student2 = new Student(2, "Sara", "Said", "F", 23);
			Student student3 = new Student(3, "Ali", "Hassan", "M", 24);
			Student student4 = new Student(4, "Sama", "Karim", "F", 20);
			Student student5 = new Student(5, "Khaled", "Mohamed", "M", 22);
			Student student6 = new Student(6, "Ghada", "Sarhan", "F", 21);

			//Create a new list of student objects
			List<Student> students = new ArrayList<>();
			students.add(student1);
			students.add(student2);
			students.add(student3);
			students.add(student4);
			students.add(student5);
			students.add(student6);

			//We have to create the CSVPrinter class object
			Writer writer = Files.newBufferedWriter(Paths.get("student.csv"));
			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Id", "FirstName", "LastName", "Gender", "Age"));

			//Writing records in the generated CSV file
			for (Student student : students) {
				csvPrinter.printRecord(student.getId(), student.getLastName(), student.getGender(), student.getAge());
			}

			//Writing records in the form of a list
			// csvPrinter.printRecord(Arrays.asList(7, "Dev", "Bhatia", "F", 20));

			csvPrinter.flush();

			System.out.println("Write csv file by using new Apache lib successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
