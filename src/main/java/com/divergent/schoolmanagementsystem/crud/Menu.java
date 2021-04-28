package com.divergent.schoolmanagementsystem.crud;

import java.util.Scanner;

import org.hibernate.validator.constraints.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Menu {
	private static final Logger myLogger = LoggerFactory.getLogger(Menu.class.getName());
	private Scanner scanner = new Scanner(System.in);
	@Autowired
	private ClassCrud classCrud;
	@Autowired
	private StudentCrud studentCrud;
	@Autowired
	private SubjectCrud subjectCrud;
	@Autowired
	private TeacherCrud teacherCrud;

	public void showMenu() {
		while (true) {
			System.out.println(" ----------------------All Crud Operation------------------------");
			System.out.println("\nSelect Option");
			System.out.println("1. Student : \n2. Class : \n3. Teacher : \n4. Subject :\n5. Exit : ");
			@Range(min = 1, max = 5)
			int choice = 0;
			System.out.println("\nEnter Choice The Option----: ");
			choice = scanner.nextInt();
	         switch (choice) {
			case 1: {
				studentCrud.showStudentMenu();
				break;
			}
			case 2: {
				classCrud.showClassMenu();
				break;
			}
			case 3: {
				teacherCrud.showTeacherMenu();
				break;
			}
			case 4: {
				subjectCrud.showSubjectMenu();
				break;
			}
			case 5:
				myLogger.info("\n------Thank you!  Application Has Shut Down Run Again ");
				System.exit(0);
			default:
				myLogger.warn("--- -Worng Choioce---- \n");
				continue;
			}
		}

	}
}
