package movie;

import java.io.Serializable;

enum ShowStatus implements Serializable {
	COMINGSOON("Coming Soon"), 
	PREVIEW("Preview"),
	NOWSHOWING("Now Showing"), 
	ENDOFSHOWING("End of Showing");
	
	private String name;
	
	ShowStatus(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() { return name; }
};
