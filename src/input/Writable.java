package input;

import java.io.Serializable;
import java.util.UUID;

/**
 * All model classes that have to be serialized will need to extend Writable.
 * Writable creates the UUID for each object which will be used as the file name.
 * @author Tan Say Hong
 *
 */
public abstract class Writable implements Serializable {

	private static final long serialVersionUID = 4466585577321415631L;
	private UUID id = UUID.randomUUID();
	
	public UUID getID() { return id; }
	public String getFilename() { return id.toString() + ".ser"; }
}
