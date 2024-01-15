package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static final String USER = "student";
	private static final String PWD = "student";
	Connection conn;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load driver");
			System.out.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void startDBConnection() {
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			System.out.println("Cannot make connection to DB");
			System.out.println(e);
			e.printStackTrace();
			System.exit(1);

		}
	}

	public void closeDBConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Cannot close DB connection");
			System.out.println(e);
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		startDBConnection();

		Film film = null;
		String sql = "SELECT * " + " FROM film JOIN language ON film.language_id = language.id " + " WHERE film.id =?;";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				film = new Film();
				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleaseYear(filmResult.getInt("release_year"));
				film.setLanguageId(filmResult.getInt("language_id"));
				film.setRentalDuration(filmResult.getInt("rental_duration"));
				film.setRentalRate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacementCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecialFeatures(filmResult.getString("special_features"));
				film.setLanguage(filmResult.getString("name"));
				// setting actor list in the film
				film.setActorList(findActorsByFilmId(filmId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDBConnection();
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		startDBConnection();
		Actor actor = null;
		String sql = "SELECT * FROM actor WHERE id=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor();
				actor.setId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDBConnection();
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		startDBConnection();
		List<Actor> actorList = new ArrayList<>();
		String sql = "SELECT actor.id, actor.first_name, actor.last_name "
				+ " FROM actor JOIN film_actor ON actor.id=film_actor.actor_id " + " WHERE film_actor.film_id = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet actorResult = stmt.executeQuery();
			while (actorResult.next()) {
				Actor actor = new Actor();
				actor.setId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));
				actorList.add(actor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDBConnection();
		return actorList;
	}

	@Override
	public List<Film> findFilmBySearchKeyword(String searchKeyword) {
		startDBConnection();
		List<Film> filmList = new ArrayList<Film>();
		String sql = "SELECT * " + " FROM film JOIN language ON film.language_id = language.id "
				+ " WHERE film.title LIKE ? OR film.description LIKE ?";
		String matchedText = "%" + searchKeyword + "%";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, matchedText);
			stmt.setString(2, matchedText);
			ResultSet filmResult = stmt.executeQuery();
			while (filmResult.next()) {
				Film film = new Film();
				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleaseYear(filmResult.getInt("release_year"));
				film.setLanguageId(filmResult.getInt("language_id"));
				film.setRentalDuration(filmResult.getInt("rental_duration"));
				film.setRentalRate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacementCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecialFeatures(filmResult.getString("special_features"));
				film.setLanguage(filmResult.getString("name"));
				// setting actor list in the film
				film.setActorList(findActorsByFilmId(film.getId()));
				filmList.add(film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDBConnection();
		return filmList;
	}

}
