package biglietteria.cinema.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import biglietteria.cinema.enumType.Type;
import biglietteria.cinema.model.CinemaRoom;
import biglietteria.cinema.model.Film;

//#################### PATTERN SINGLETON #########
public final class CinemaDatabase {

	private static CinemaDatabase instance = null;
	private List<Film> films = new ArrayList<Film>();
	private List<CinemaRoom> rooms = new ArrayList<CinemaRoom>();
	
	
	// MANIPOLAZIONE DELLA STRUTTURA DEL DATABASE
	
	public List<Film> getFilms() {
		return films;
	}
	
	public List<CinemaRoom> getRooms(){
		return rooms;
	}
	
	private void insertFilm() {
		films = Arrays.asList(
				new Film("Matrix", "Andy e Larry Wachowski", 1999, 136, Type.ACTION),
				new Film("Halloween – La notte delle streghe", " John Carpenter", 1978, 106, Type.HORROR),
				new Film("La casa di carta", "Alejandro Pina Calafi", 1999, 60, Type.THRILLER),
				new Film("The Imitation Game", "Morten Tyldum", 2014, 114, Type.ACTION),
				new Film("Cado dalle Nubi", "Gennaro Nunziante", 2009, 95, Type.COMEDY));
	}	
	
	private void insertRoom() {
		rooms = Arrays.asList( 
				new CinemaRoom(101, films.get(3), 0, false),
				new CinemaRoom(102, films.get(2), 0, false),
				new CinemaRoom(103, films.get(0), 0, false),
				new CinemaRoom(104, films.get(1), 0, false),
				new CinemaRoom(105, films.get(4), 0, false)
				);
	}

	public static CinemaDatabase getInstance() {
		if (instance == null)
			instance = new CinemaDatabase();
		return instance;
	}

	private CinemaDatabase() {
		insertFilm();
		insertRoom();
	}
}