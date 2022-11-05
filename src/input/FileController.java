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


public class FileController {
	@SuppressWarnings("unchecked")
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
	
	public static void delete(String filepath) {
		File file = new File(filepath);
		file.delete();
	}
}
