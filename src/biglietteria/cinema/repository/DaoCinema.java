package biglietteria.cinema.repository;

import java.util.List;
import biglietteria.cinema.database.CinemaDatabase;
import biglietteria.cinema.model.*;

public final class DaoCinema {

	// ######### VARIABILI #########

	private static DaoCinema instance = null;
	private final CinemaDatabase cinemaDatabase = CinemaDatabase.getInstance();

	// ######### OPERAZIONI #########

	// 1) RICERCA FILM PER NOME
	public Film findBy(String name) throws FilmNotFoundException {
		
		List<Film> films = cinemaDatabase.getFilms();

		for(Film film: films) {
			if(film.getFilmName().equalsIgnoreCase(name))
				return film;
		}
		return null;
	}

	// 2) RICERCA FILM PER ANNO DI USCITA
	public Film findBy(int year) throws FilmNotFoundException {
		
		List<Film> films = cinemaDatabase.getFilms();

		for(Film film: films) {
			if(film.getYear() == year )
				return film;
		}
		return null;
	}

	// 3) ORDINAMENTO DI SELEZIONE 
	public List<Film> sortingFilmsByName() {
		
		List<Film> list = cinemaDatabase.getFilms();
		Film elDaIns;
		int i, j;

		for (i = 1; i < list.size(); i++) {
			elDaIns = list.get(i);
			j = i - 1;
			while (j >= 0 && elDaIns.getFilmName().compareTo(list.get(j).getFilmName()) < 0) {
				list.set(j+1, list.get(j));
				j--;
			}
			list.set(j+1, elDaIns);
		}
		return list;
	}

	// 4) ORDINAMENTO DI SELEZIONE 
	public List<Film> sortingFilmsByYear() {

		List<Film> list = cinemaDatabase.getFilms();
		Film elDaIns;
		int i, j;
		
		for (i = 1; i < list.size(); i++) {
			elDaIns = list.get(i);
			j = i - 1;
			while (j >= 0 && elDaIns.getYear() < list.get(j).getYear()) {
				list.set(j+1, list.get(j));
				j--;
			}
			list.set(j+1, elDaIns);
		}
		return list;
	}
	
	// 5) ORDINAMENTO DI SELEZIONE
	public List<CinemaRoom> sortingFilmsByAvailableSeatsDesc() {

		List<CinemaRoom> list = cinemaDatabase.getRooms();
		CinemaRoom elDaIns;
		int i, j;
		
		for (i = 1; i < list.size(); i++) {
			elDaIns = list.get(i);
			j = i - 1;
			while (j >= 0 && elDaIns.getAvailableSeats() < list.get(j).getAvailableSeats()) {
				list.set(j+1, list.get(j));
				j--;
			}
			list.set(j+1, elDaIns);
		}
		return list;
	}

	// 6) RICERCA SALA
	public CinemaRoom findCinemaRoom(int id) throws RoomNotFoundException, Exception {
		
		int i; 
		List<CinemaRoom> rooms = cinemaDatabase.getRooms();
		
		for(i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).getId() == id)
				return rooms.get(i);
		}
		return null;
	}

	// 7) RECUPERO LISTA SALE PRESENTI NEL CINEMA
	public List<CinemaRoom> getRooms() {
		return cinemaDatabase.getRooms();
	}

	
	public static DaoCinema getInstance() {
		if (instance == null)
			instance = new DaoCinema();
		return instance;
	}

	private DaoCinema() {

	}
}
