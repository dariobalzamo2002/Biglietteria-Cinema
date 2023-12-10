package biglietteria.cinema.view;

import java.util.List;
import java.util.Scanner;
import biglietteria.cinema.model.CinemaRoom;
import biglietteria.cinema.model.Film;

public final class InterfaceView {

	// ######### VARIABILI #########

	private static InterfaceView instance = null;

	// ######### OPERAZIONI #########

	public int readInt(String message) throws NumberFormatException, Exception {
		Scanner input = new Scanner(System.in);
		System.out.print(message);
		return input.nextInt();
	}

	public String readString(String message) {
		Scanner input = new Scanner(System.in);
		System.out.print(message);
		return input.nextLine();
	}

	public void pause(String message) {
		Scanner input = new Scanner(System.in);
		System.out.print(message);
		input.nextLine();
	}

	public void menu() {
		System.out.println("################ UCI CINEMA - TICKET OFFICE ################");
		System.out.println("############################################################");
		System.out.println("###                                                   	 ###");
		System.out.println("###\t [1] Seat reservation                            ###");
		System.out.println("###\t [2] Search for movies by name                   ###");
		System.out.println("###\t [3] Search for movies by year                   ###");
		System.out.println("###\t [4] View movie list sorted by name              ###");
		System.out.println("###\t [5] View movie list sorted by year              ###");
		System.out.println("###\t [6] View movie list sorted by available seats   ###");
		System.out.println("###\t [0] EXIT                                        ###");
		System.out.println("###                                                   	 ###");
		System.out.println("############################################################");
	}

	// Mostra la lista dei film presenti nelle sale
	public void movieInTheaters(List<CinemaRoom> rooms) {

		int i;
		System.out.println("## MOVIE FOR TONIGHT ##");
		System.out.println("** GATE ** ## ***** MOVIE ***** ## DETAILS");
		for (i = 0; i < rooms.size(); i++)
			System.out.println(rooms.get(i));
	}

	
	/////// OVERLOAD ////////////////////////////////////////////
	
	public void showFilm(Film film) {

		System.out.println("****** FILM ******");
		System.out.println(film);
	}

	public void showFilm(List<Film> films) {

		System.out.println("****** FILM ******");
		for (Film film : films)
			System.out.println(film);
	}

	//////////////////////////////////////////////////////////////

	public void messageDisplay(String message) {
		System.out.println(message);
	}

	public static InterfaceView getInstance() {
		if (instance == null)
			instance = new InterfaceView();
		return instance;
	}

	private InterfaceView() {

	}
}
