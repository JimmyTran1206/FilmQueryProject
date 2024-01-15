package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() {
		Scanner input = new Scanner(System.in);
		displayMenu();
		startUserInterface(input);

		input.close();
	}

	private void displayMenu() {
		System.out.println("Choose an option:");
		System.out.println("1. Look up a film by its id.");
		System.out.println("2. Look up a film by a search keyword.");
		System.out.println("3. Exit the application");
		System.out.print("Your choice: ");
	}

	private void startUserInterface(Scanner input) {
		// Process user Choice
		while (true) {
			String userChoice = input.nextLine();
			switch (userChoice) {
			case "1":
				userSearchFilmById(input);
				displayMenu();
				break;
			case "2":
				userSeachFilmByKeyword(input);
				displayMenu();
				break;
			case "3":
				System.out.println("Good bye!");
				System.out.println("System exiting....");
				return;
			default:
				System.out.println("Invalid choice. Please choose 1,2,or 3.");
				displayMenu();
			}
		}

	}

	private void userSearchFilmById(Scanner input) {
		while (true) {
			System.out.println();
			System.out.println("Please enter a valid film id or 'Q' to return to the main menu: ");
			System.out.print("Your choice: ");
			String filmIdStr = input.nextLine();
			System.out.println();
			if (filmIdStr.toUpperCase().equals("Q")) {
				return;
			}
			try {
				int filmId = Integer.parseInt(filmIdStr);
				Film film = db.findFilmById(filmId);
				if (film == null) {
					System.out.println("Sorry! No film matching the id " + filmId);
				} else {
					System.out.println(film);
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid film id input!");
			}

		}

	}
	
	private void userSeachFilmByKeyword(Scanner input) {
		while (true) {
			System.out.println();
			System.out.print("Please enter a search keyword: ");
			String userSearchKeyword= input.nextLine();
			System.out.println();
			List<Film> filmList = db.findFilmBySearchKeyword(userSearchKeyword);
			if(filmList.isEmpty()) {
				System.out.println("There is no film matched your search.");
				System.out.println();
			}else {
				System.out.println();
				for (Film film : filmList) {
					System.out.println(film);
				}
				System.out.println("There are " + filmList.size()+ " films matched your search.");
				System.out.println();
			}
			System.out.println("Press any key to continue searching, or press 'Q' to return to main menu.");
			String userChoice=input.nextLine();
			if(userChoice.toUpperCase().equals("Q")) {
				return;
			}
		}
	}

// End of file
}
