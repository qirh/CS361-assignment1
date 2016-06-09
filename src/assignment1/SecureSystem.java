package assignment1;


import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

enum Level {
    HIGH, LOW 
}

public class SecureSystem {

	public static void main(String[] args) {
		try {
			new Reader(args[0]).read();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		catch (Exception e){
			System.err.println("Invalid arguments count:" + args.length);
			System.exit(0);
		}
	}
}

class SecurityLevel{
	
	public void setLevel(int x){
		
	}
	
	public boolean dominates(int x, int y){
		return  x>= y;
	}
}

class SubjectManager{
	String name;
	int temp;
	int level;
}
class ReferenceMonitor{
	class ObjectManager{
		String name;
		int value;
		int level;
	}
}
class InstructionObject{
	String ope;
	String sub;
	String obj;
	int value;
	boolean valid;
	
	InstructionObject(){
		valid = true;
	}
	InstructionObject(String line){
		isValid(line);
	}
	
	boolean isValid(String line){
		String[] tokens = line.split(" ");
		
		if (tokens[0].equals("READ") && tokens.length == 3){
			//if (tokens[1].isSubject())
		}
		else if (tokens[0].equals("WRITE") && tokens.length == 4){
			
		}
		
		return false;
	}
	
	static final class BadInstruction{
		
	}
}


class Reader { 
	private  ArrayList<InstructionObject> ins = new ArrayList<InstructionObject>();
	String path;
	
	Reader(String path){
		this.path = path;
	}
	
	void read () throws FileNotFoundException{
		File input = new File(path);
		
		if(!input.exists() || input.isDirectory()) { 
			throw new FileNotFoundException("File not found at path: " + path);
		}
		
	    BufferedReader br = null;

	    try {
	    	String line;
		     br = new BufferedReader(new FileReader(input));
		     while ((line = br.readLine()) != null) {
		    	 System.out.println(line);
		    	 makeInstructions(line);
		     }
	    } 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (br != null)
					br.close();
		    } 
			catch (IOException ex) {
				ex.printStackTrace();
		    }
		}
	}
	
	private static void makeInstructions(String line){
		
	}
}
