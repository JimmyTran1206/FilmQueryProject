package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actorList;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Film details: \n");
		sb.append("title: "+ title + "\n");
		sb.append("id: "+ id + "\n");
		sb.append("description: "+ description + "\n");
		sb.append("release_year: "+ releaseYear + "\n");
		sb.append("language_id: "+ languageId + "\n");
		sb.append("rental_duration: "+ rentalDuration + "\n");
		sb.append("rental_rate: "+ rentalRate + "\n");
		sb.append("length: "+ length + "\n");
		sb.append("replacement_cost: "+ replacementCost + "\n");
		sb.append("rating: "+ rating + "\n");
		sb.append("special_features: "+ specialFeatures + "\n");
		sb.append("\nActor List: \n");
		int count=1;
		for (Actor actor:actorList) {
			sb.append(count+". ");
			sb.append(actor.getFirstName());
			sb.append(" ");
			sb.append(actor.getLastName());
			sb.append(". \n");
			count++;
		}
		return sb.toString();
//		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
//				+ ", languageId=" + languageId + ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate
//				+ ", length=" + length + ", replacementCost=" + replacementCost + ", rating=" + rating
//				+ ", specialFeatures=" + specialFeatures + ", actorList=" + actorList + "]";
	}

	public Film(int id, String title, String description, int releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			List<Actor> actorList) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actorList = actorList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}

	public Film() {
		super();
	}
}
