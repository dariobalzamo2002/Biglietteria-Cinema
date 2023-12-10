package biglietteria.cinema.controller;

import java.io.IOException;

import biglietteria.cinema.model.*;
import biglietteria.cinema.repository.DaoCinema;
import biglietteria.cinema.view.InterfaceView;

public final class Controller {

	private final static InterfaceView VIEW = InterfaceView.getInstance();
	private final static DaoCinema daoCinema = DaoCinema.getInstance();

	
	public static void main(String[] args) {

		// VARIABILI PROGRAMMA
		int choice = 0, year = 0, seats = 0;
		boolean flag;
		CinemaRoom room = null;
		Film film = null;
		String filmName; 
		
		
		
		// BUSINESS LOGIC
		do {
			VIEW.menu();
			do {
				flag = false;
				try {
					choice = VIEW.readInt("Select an option: ");
				} catch (NumberFormatException e) {
					System.err.println("Enter a number !");
				} catch (Exception e) {
					System.err.println("Enter a number !");
					flag = true;
				}
			} while (flag);
			switch (choice) {
			case 1: // PRENOTAZIONE BIGLIETTO CINEMA
				VIEW.movieInTheaters(daoCinema.getRooms());
				do {
					flag = false;
					try {
						choice = VIEW.readInt("Select room: ");
						seats = VIEW.readInt("Select number of tickets: ");
					} catch (NumberFormatException e) {
						System.err.println("Enter a number !");
					} catch (Exception e) {
						System.err.println("Enter a number !");
						flag = true;
					}
				} while (flag);

				try {
					room = daoCinema.findCinemaRoom(choice);
					if (room == null) {
						throw new RoomNotFoundException();
					} else {
						if (room.checkAvailableRoom(seats)) {
							VIEW.messageDisplay( seats + " ticket for the film '" + room.getFilm().getFilmName()
									+ "' successfully reserved !");
							VIEW.messageDisplay("Remaining seats in the room " + room.getId()+ ": " + room.getAvailableSeats());
						}else
							VIEW.messageDisplay(
									"The hall for the film '" + room.getFilm().getFilmName() + "' is sold out");
					}
				} catch (RoomNotFoundException e) {
					System.err.println("Room not found !");
				} catch (Exception e) {
					System.err.println("Room not found !");
				}
				VIEW.pause("Submit to continue...");
				break;
			case 2: // CERCA FILM PER NOME
				filmName = VIEW.readString("Search movie: ");
				try {
					film = daoCinema.findBy(filmName);
					if ( film == null)
						throw new FilmNotFoundException();
					else
						VIEW.showFilm(film);
				} catch (FilmNotFoundException e) {
					System.err.println("Film not found !");
				} catch (Exception e) {
					System.err.println("Film not found !");
				}
				VIEW.pause("Submit to continue...");
				break;
			case 3: // CERCA FILM PER ANNO
				do {
					flag = false;
					try {
						year = VIEW.readInt("Search movie: ");
					} catch (NumberFormatException e) {
						System.err.println("Enter a number !");
					} catch (Exception e) {
						System.err.println("Enter a number !");
						flag = true;
					}
				} while (flag);
				try {
					film = daoCinema.findBy(year);
					if ( film == null)
						throw new FilmNotFoundException();
					else
						VIEW.showFilm(film);
				} catch (FilmNotFoundException e) {
					System.err.println("Film not found !");
				} catch (Exception e) {
					System.err.println("Film not found !");
				}
				VIEW.pause("Submit to continue...");
				break;
			case 4: // VISUALIZZA LISTA FILM ORDINATI PER NOME
				VIEW.showFilm(daoCinema.sortingFilmsByName());
				VIEW.pause("Submit to continue...");
				break;
			case 5: // VISUALIZZA LISTA FILM ORDINATI PER ANNO
				VIEW.showFilm(daoCinema.sortingFilmsByYear());
				VIEW.pause("Submit to continue...");
				break;
			case 6:	// VISUALIZZA LISTA FILM ORDINATI PER POSTI DISPONIBILI 
				VIEW.movieInTheaters(daoCinema.sortingFilmsByAvailableSeatsDesc());
				VIEW.pause("Submit to continue...");
				break;
			default:
				if(choice != 0)
					System.err.println("Select a valid option !");
			}
		} while (choice != 0);
		System.out.println("EXIT by UCI CINEMAS");
	}
}