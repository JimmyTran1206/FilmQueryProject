package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	Scanner input;

	private DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
//		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		input = new Scanner(System.in);
		displayMenu();

		startUserInterface(input);

		input.close();
	}
	 private void displayMenu() {
		 System.out.println("Choose an option:");
		 System.out.println("1. Look up a film by its id.");
		 System.out.println("2. Look up a film by a search keyword.");
		 System.out.println("3. Exit the application");
	 }
	private void startUserInterface(Scanner input) {

	}

}
