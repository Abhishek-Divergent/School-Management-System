package com.divergent.schoolmanagementsystem.crud;

import java.util.Scanner;

import org.hibernate.validator.constraints.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.schoolmanagementsystem.doa.StudentDoa;

@Component
public class StudentCrud {
	private static final Logger myLogger = LoggerFactory.getLogger(Menu.class.getName());
	private Scanner scanner = new Scanner(System.in);
	@Autowired
	StudentDoa studentDoa;

	public void showStudentMenu() {
		s_panel: while (true) {
			myLogger.info("\n************************Student CRUD************************\n");
			System.out.println("1:Student Create : ");
			System.out.println("2:Student Read : ");
			System.out.println("3:Student Update : ");
			System.out.println("4:Student Delete : ");
			System.out.println("5:Exit :  \n");
			System.out.print("\nEnter Choice The Option----:  ");
			@Range(min = 1, max = 5)
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				create();
				break;
			case 2:
				read();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				break s_panel;
			default:
				myLogger.warn("----Worng Choioce----\n");
				continue;
			}
		}

	}

	public void delete() {

		myLogger.info("---------------Delete Operation------------");
		System.out.println("\n\n Enter Student Id to Delete :------- ");
		int id = scanner.nextInt();
		try {
			studentDoa.delete(id);
			myLogger.info("--Data Sucessfully Deleted --");
		} catch (Exception e) {
			myLogger.warn(e + " ");
			myLogger.info("--Data UNSucessfully Deleted --");
		}

	}

	public void update() {
		read();
		myLogger.info("---------------Update Operation------------");
		try {

			System.out.println("\n\n Enter Student Id to Update :------- ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println(" \n Student Id ------- " + id);
			System.out.println(" Enter Student First Name : ");
			String firstname = scanner.nextLine().trim().toLowerCase();
			System.out.println(" Enter Student Last Name : ");
			String lastname = scanner.nextLine().trim().toLowerCase();
			System.out.println(" \nEnter Student Class  Id ------- ");
			int classid = scanner.nextInt();
			studentDoa.update(id, firstname, lastname, classid);
			myLogger.info("--Data Sucessfully Updated --");

		} catch (Exception e) {
			myLogger.warn(e + " ");
			myLogger.info("--Data UNSucessfully Updated --");
		}

	}

	public void create() {
		myLogger.info("---------------Create Operation------------");
		try {
			System.out.println("\n\n Enter Student Id   ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println(" Enter Student First Name : ");
			String firstname = scanner.nextLine().trim().toLowerCase();
			System.out.println(" Enter Student Last Name : ");
			String lastname = scanner.nextLine().trim().toLowerCase();
			System.out.println(" \nEnter Student Class  Id ------- ");
			int classid = scanner.nextInt();
			studentDoa.create(id, firstname, lastname, classid);
			myLogger.info("--Data Sucessfully Created --");
		} catch (Exception e) {
			myLogger.warn(e + " ");
			myLogger.info("--Data UNSucessfully Created --");
		}

	}

	public void read() {
		myLogger.info("---------------Read Operation------------");
		try {
			studentDoa.read();
		} catch (Exception e) {
			myLogger.warn(e + " ");
		}
	}

}
