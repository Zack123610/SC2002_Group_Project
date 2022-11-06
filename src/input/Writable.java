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

	/**
	 * static final UUID for Writable objects
	 */
	private static final long serialVersionUID = 4466585577321415631L;

	/**
	 * A random UUID generated
	 */
	private UUID id = UUID.randomUUID();
	
	/**
	 * Gets the UUID of the object
	 * @return a UUID
	 */
	public UUID getID() { return id; }

	/**
	 * Creates a file name of the serialised class
	 * @return the new file name
	 */
	public String getFilename() { return id.toString() + ".ser"; }
}
