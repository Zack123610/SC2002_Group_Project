package globals;

import java.io.Serializable;
import java.util.UUID;

@SuppressWarnings("serial")
public abstract class Writable implements Serializable {
	private UUID id = UUID.randomUUID();
	
	public UUID getID() {
		return id;
	}
	
	public String getFilename() {
		return id.toString() + ".ser";
	}
}
