package movie;

import java.io.Serializable;

import movie.ticket.ITicketAttribute;

public enum Genre implements ITicketAttribute, Serializable {
	THREED("3D"),
	ACTION("Action"),
	ADVENTURE("Adventure"),
	ANIME("Anime"),
	BLOCKBUSTER("Blockbuster"),
	COMEDY("Comedy"),
	DRAMA("Drama"),
	FANTASY("Fantasy"),
	HORROR("Horror"),
	MYSTERY("Mystery"),
	ROMANCE("Romance"),
	THRILLER("Thriller"),
	SCI_FI("Sci-Fi");

	
	private String name;
	private double multipler;
	
	// By default, all the genres' multiplier initialised to 1.0.
	// Able to change this via SettingsController
	Genre(String name) {
		this.name = name;
		this.multipler = 1.0;
	}

	@Override
	public String toString() { return name; }
	@Override
	public double getMultiplier() { return multipler; }
	@Override
	public void setMultiplier(double multiplier) { this.multipler = multiplier; }
}
