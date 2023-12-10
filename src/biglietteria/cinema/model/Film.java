package biglietteria.cinema.model;

import java.util.Objects;
import biglietteria.cinema.enumType.Type;

// ################### PATTERN CHAINING ###################
public class Film {

	// Attributes
	
	private String filmName;
	private String filmDirector;
	private int year;
	private int time;
	private Type filmType;

	// Getter & Setter

	public String getFilmName() {
		return filmName;
	}

	public Film setFilmName(String filmName) {
		this.filmName = filmName;
		return this;
	}

	public String getFilmDirector() {
		return filmDirector;
	}

	public Film setFilmDirector(String filmDirector) {
		this.filmDirector = filmDirector;
		return this;
	}

	public int getYear() {
		return year;
	}

	public Film setYear(short year) {
		this.year = year;
		return this;
	}

	public int getTime() {
		return time;
	}

	public Film setTime(short time) {
		this.time = time;
		return this;
	}

	public Type getFilmType() {
		return filmType;
	}

	public Film setFilmType(Type filmType) {
		this.filmType = filmType;
		return this;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(filmDirector, filmName, filmType, time, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(filmDirector, other.filmDirector) && Objects.equals(filmName, other.filmName)
				&& filmType == other.filmType && time == other.time && year == other.year;
	}
	
	@Override
	public String toString() {
		return filmName + " by "+ filmDirector + " - " + year + ", " + time
				+ " min, " + filmType;
	}
	
	
	// Costructors

	public Film() {

	}

	public Film(String filmName, String filmDirector, int year, int time, Type filmType) {
		super();
		this.filmName = filmName;
		this.filmDirector = filmDirector;
		this.year = year;
		this.time = time;
		this.filmType = filmType;
	}
}