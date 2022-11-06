package input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;


/**
 * The FileController class contains methods to read, write and delete files
 */
public class FileController {

	@SuppressWarnings("unchecked")
	/**
	 * Reads a file from filepath and return an ArrayList of objects. It makes the necessary error checking
	 * 
	 * @param <T> is the type of object to be read and returned
	 * @param filepath is the relative filepath to be read
	 * @return an arraylist of objects
	 */
	public static <T extends Writable> ArrayList<T> read(String filepath) {
		
		ArrayList<T> res = new ArrayList<>();
		
		try {
			File[] files = new File(filepath).listFiles();
			
			for (File file : files) {
				FileInputStream fileIn = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				
				T obj = (T) in.readObject();
				res.add(obj);
				
				in.close();
				fileIn.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error has occured");
		}
		
		return res;
	}
	
	/**
	 * Writes an arraylist of objects to a file in filepath. It makes the necessary error checking
	 * @param <T>  is the type of object to be written
	 * @param data is the arraylist of objects
	 * @param filepath is the relative filepath to be written to
	 */
	public static <T extends Writable> void write(Collection<T> data, String filepath) {
		  try { 
			  for (T curr : data) { 
				  String filename = filepath + curr.getFilename();
				  FileOutputStream file = new FileOutputStream(new File(filename)); 
				  ObjectOutputStream obj = new ObjectOutputStream(file);
				  
				  obj.writeObject(curr); 
				  
	 			  obj.close(); 
	 			  file.close(); 
				}
		  } catch (FileNotFoundException e) {
			  System.out.println("File not found"); 
		  } catch (IOException e) {
			  System.out.println("Error initializing stream"); 
			  e.printStackTrace();
		  } catch (Exception e) {
			  e.printStackTrace();
			  System.out.println("An error has occured.");
		  }
	}
	
	/**
	 * Deletes a file from the filepath
	 * @param filepath is the filepath of the file to be deleted
	 */
	public static void delete(String filepath) {
		File file = new File(filepath);
		file.delete();
	}
}
