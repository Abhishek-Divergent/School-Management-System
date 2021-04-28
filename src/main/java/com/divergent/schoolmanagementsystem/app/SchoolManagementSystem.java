package com.divergent.schoolmanagementsystem.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.divergent.schoolmanagementsystem.configuration.JavaConfig;
import com.divergent.schoolmanagementsystem.crud.Menu;

public class SchoolManagementSystem {
	private static final Logger myLogger = LoggerFactory.getLogger(SchoolManagementSystem.class.getName());

	public static void main(String[] args) {
		myLogger.info(" Welcome School Mangement System ");
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Menu menu = context.getBean(Menu.class);
		menu.showMenu();
	}
}
