package movie;

import java.io.Serializable;

public enum MovieRating implements Serializable {
	G("G"),
	PG("PG"),
	PG13("PG13"),
	NC16("NC16"),
	M18("M18"),
	R21("R21");

	private String name;
	
	MovieRating(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
