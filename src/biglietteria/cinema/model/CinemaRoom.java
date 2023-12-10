package biglietteria.cinema.model;

public class CinemaRoom {

	// Attributes

	private int id;
	private final short seatingCapacity = 5; // Capienza massima per ciascuna sala del cinema.
	private boolean soldOut;
	private int ticketsSold;
	private Film film;

	// Getter & Setter

	public int getId() {
		return id;
	}

	public CinemaRoom setId(byte id) {
		this.id = id;
		return this;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public boolean getSoldOut() {
		return soldOut;
	}

	public CinemaRoom setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
		return this;
	}

	public int getTicketsSold() {
		return ticketsSold;
	}

	public CinemaRoom setTicketsSold(int ticketsSold) {
		this.ticketsSold = ticketsSold;
		return this;
	}

	public Film getFilm() {
		return film;
	}

	public CinemaRoom setFilm(Film film) {
		this.film = film;
		return this;
	}

	// OPERATIONS
	
	public boolean checkAvailableRoom(int seats) {
		if (!this.soldOut && this.ticketsSold < this.seatingCapacity) {
			this.setTicketsSold(this.ticketsSold+seats).setSoldOut(false);
			return true;
		} else {
			this.setSoldOut(true);
			return false;
		}
	}
	
	public int getAvailableSeats() {
		return (this.seatingCapacity - this.ticketsSold);
	}

	@Override
	public String toString() {
		return "   " + id + "     " + film.getFilmName() + ", sold-out: " + soldOut + ", available seats: " + getAvailableSeats();
	}
	
	// Costructors
	
	public CinemaRoom() {

	}

	public CinemaRoom(int id, Film film ,int ticketsSold, boolean soldOut) {
		super();
		this.id = id;
		this.film = film;
		this.ticketsSold = ticketsSold;
		this.soldOut = soldOut;
	}

}
