package biglietteria.cinema.model;

public class FilmNotFoundException extends Exception{

	private static final long serialVersionUID = 852705934283778556L;

	public FilmNotFoundException() {
		super("Film not found !");
	}
}
