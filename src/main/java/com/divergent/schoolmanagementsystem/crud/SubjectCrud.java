package com.divergent.schoolmanagementsystem.crud;

import java.util.Scanner;

import org.hibernate.validator.constraints.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.schoolmanagementsystem.app.SchoolManagementSystem;
import com.divergent.schoolmanagementsystem.doa.SubjectDao;

@Component
public class SubjectCrud {
	private static final Logger myLogger = LoggerFactory.getLogger(SchoolManagementSystem.class.getName());
	private Scanner scanner = new Scanner(System.in);
	@Autowired
	SubjectDao subjectDao;

	public void showSubjectMenu() {
		s_panel: while (true) {
			myLogger.info("\n************************Subject CRUD************************\n");
			System.out.println("1:Subject Create : ");
			System.out.println("2:Subject Read : ");
			System.out.println("3:Subject Update : ");
			System.out.println("4:subject Delete : ");
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
		System.out.println("\n\n Enter Subject Id to Delete :------- ");
		int id = scanner.nextInt();
		try {
			subjectDao.delete(id);
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

			System.out.println("\n\n Enter Subject Id to Update :------- ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println(" \nSubject Id ------- " + id);
			System.out.println(" Enter Subject Name : ");
			String name = scanner.nextLine().trim().toLowerCase();
			subjectDao.update(id, name);

			myLogger.info("--Data Sucessfully Updated --");

		} catch (Exception e) {
			myLogger.warn(e + " ");
			myLogger.info("--Data UNSucessfully Updated --");
		}
	}

	public void create() {
		myLogger.info("---------------Create Operation------------");
		try {
			System.out.println(" Enter Subject Id : ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println(" Enter Subject Name : ");
			String name = scanner.nextLine().trim().toLowerCase();
			subjectDao.create(id, name);
			myLogger.info("--Data Sucessfully Created --");
		} catch (Exception e) {
			myLogger.warn(e + " ");
			myLogger.info("--Data UNSucessfully Created --");
		}
	}

	public void read() {
		myLogger.info("---------------Read Operation------------");
		try {
			subjectDao.read();
		} catch (Exception e) {
			myLogger.warn(e + " ");
		}
	}
}