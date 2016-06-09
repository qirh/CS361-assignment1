
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


enum Level {
    HIGH, LOW 
}

public class SecureSystem{
	
	private static SecureSystem instance = null;
	public static SubjectManager sm = new SubjectManager();
	public static ReferenceMonitor rm = new ReferenceMonitor();
	
	public static void main(String[] args) {
		
		
		sm.createSubject("lyle", Level.LOW);
		sm.createSubject("hal", Level.HIGH);
		
		rm.om.createObject("lobj", 0, Level.LOW);
		rm.om.createObject("hobj", 0, Level.HIGH);
		
		read(args);
		
	}
	
	void printState(){
		System.out.print(rm.om.printObjects());
		System.out.print(sm.printSubjects());
	}
	
	private SecureSystem(){}
	
	public static SecureSystem getSys(){
		if( instance == null)
			instance = new SecureSystem();
		return instance;
	}
	
	static void read(String[] args){
		try {
			new Reader(args[0]).read();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		catch (Exception e){
			e.printStackTrace();
			System.err.println("Invalid arguments count:" + args.length);
			System.exit(0);
		}
	}
}

class SecurityLevel{
	
	static boolean dominates(Level x, Level y){
		if ((x == Level.LOW) && (y == Level.HIGH)){
			return false;
		}
		return true;
	}
}

class SubjectManager{
	private static ArrayList<Subject> list = new ArrayList<Subject>();
	
	private class Subject{
		String name;
		int temp;
		Level level;
		
		Subject(String name, int temp, Level level){
			this.name = name;
			this.temp = temp;
			this.level = level;
		}
		void setTemp(int temp){
			this.temp = temp;
		}
	}
		
	boolean createSubject(String name, Level level){
		if(subjectExists(name))
				return false;
		list.add(new Subject(name, 0, level));
		//System.out.println("Subject " + name + " added");
		return true;
	}
	boolean subjectExists(String name){
		for (Subject x: list)
			if(x.name.equalsIgnoreCase(name))
				return true;
		//System.out.println("Subject " + name + " does not exist");
		return false;
	}
	String printSubjects(){
		String s = "";
		for (Subject x: list)
			s = s + "\t" + x.name + " has recently read: " + x.temp + "\n";
		return s+"\n";
	}
	Level subjectLevel(String name){
		for (Subject x: list)
			if(x.name.equalsIgnoreCase(name))
				return x.level;
		return null;
	}
	Subject getSubject(String name){
		for (Subject x: list)
			if(x.name.equalsIgnoreCase(name))
				return x;
		return null;
	}
	void setTemp(String name, int temp){
		for (Subject x: list)
			if(x.name.equalsIgnoreCase(name))
				x.setTemp(temp);
	}
	
		
}

class ReferenceMonitor{
	static ObjectManager om = new ObjectManager();
	
	static void runInstruction(InstructionObject ins){
		System.out.println(ins);
		if (ins != null && ins.valid){
			if (ins.op.equals("reads"))
				executeRead(ins);
			if (ins.op.equals("writes"))
				executeWrite(ins);
		}
		SecureSystem.getSys().printState();
	}
	
	static class ObjectManager{
		private static ArrayList<Object> list = new ArrayList<Object>();
		
		private class Object{
			String name;
			int value;
			Level level;
			
			Object(String name, int value, Level level){
				this.name = name;
				this.value = value;
				this.level = level;
			}
			
			void setValue(int x){
				this.value = x;
			}
		}
		
		boolean createObject(String name, int value, Level level){
			if(objectExists(name))
					return false;
			list.add(new Object(name, value, level));
			return true;
		}
		boolean objectExists(String name){
			for (Object x: list)
				if(x.name.equalsIgnoreCase(name))
					return true;
			return false;
		}
		String printObjects(){
			String s = "The current state is: \n";
			for (Object x: list)
				s = s  + "\t" + x.name + " has value: " + x.value + "\n";
			return s;
		}
		Level objectLevel(String name){
			for (Object x: list)
				if(x.name.equalsIgnoreCase(name))
					return x.level;
			return null;
		}
		Object getObject(String name){
			for (Object x: list)
				if(x.name.equalsIgnoreCase(name))
					return x;
			return null;
		}
		void setValue(String name, int temp){
			for (Object x: list)
				if(x.name.equalsIgnoreCase(name))
					x.setValue(temp);
		}	
	}
	
	static void executeRead(InstructionObject ins){
		Level subLevel = SecureSystem.sm.subjectLevel(ins.sub);
		Level objLevel = SecureSystem.rm.om.objectLevel(ins.obj);
		if(SecurityLevel.dominates(subLevel, objLevel) || subLevel == objLevel){
			System.out.println("I READ!!!!!!!");
			SecureSystem.sm.setTemp(ins.sub, SecureSystem.rm.om.getObject(ins.obj).value);
		} else {
			System.out.println("I READ!!!!!!!");
			SecureSystem.sm.setTemp(ins.sub, 0);
		}
	}
	
	static void executeWrite(InstructionObject ins){
		Level subLevel = SecureSystem.sm.subjectLevel(ins.sub);
		Level objLevel = SecureSystem.rm.om.objectLevel(ins.obj);
		if(!SecurityLevel.dominates(subLevel, objLevel) || subLevel == objLevel){
			System.out.println("I WRITE!!!!!!!");
			SecureSystem.rm.om.setValue(ins.obj, ins.value);
		}
	}
}
class InstructionObject{
	String line;
	String op;
	String sub;
	String obj;
	int value;
	boolean valid = true;
	
	InstructionObject(){
	}
	
	InstructionObject(String line){
		this.line = line;
	}
	
	public String toString() {
		if (op.equalsIgnoreCase("reads"))
			return(sub + " " + op + " " + obj);
		else
			return sub + " " + op + " value " + value + " to " + obj;
    }
	
	InstructionObject isValid(){
		String[] tokens = line.split("\\s+");
		
		if (tokens[0].equalsIgnoreCase("READ") && tokens.length == 3){
			
			if(! SecureSystem.getSys().sm.subjectExists(tokens[1])){
				return new BadInstruction();
			}
			if(! SecureSystem.getSys().rm.om.objectExists(tokens[2])){
				return new BadInstruction();
			}
			op = "reads";
			sub = tokens[1];
			obj = tokens[2];
			
		//	if(! SecurityLevel.dominates(SecureSystem.getSys().sm.subjectLevel(tokens[1]), SecureSystem.getSys().rm.om.objectLevel(tokens[1])))
			return this;
		}
		else if (tokens[0].equalsIgnoreCase("WRITE") && tokens.length == 4){
			
			if(! SecureSystem.getSys().sm.subjectExists(tokens[1])){
				return new BadInstruction();
			}
			if(! SecureSystem.getSys().rm.om.objectExists(tokens[2])){
				return new BadInstruction();
			}
			try{
				value = Integer.parseInt(tokens[3]);
			}
			catch(NumberFormatException e){
				return new BadInstruction();
			}
			op = "writes";
			sub = tokens[1];
			obj = tokens[2];
			
			return this;
		}
		return new BadInstruction();
	}
	
	static final class BadInstruction extends InstructionObject {
		String message = "Bad Instruction";
		
		BadInstruction(){
			valid = false;
		}
		public String toString() {
	        return message;
	    }

	}
}


class Reader { 
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
		    	 ReferenceMonitor.runInstruction(new InstructionObject(line).isValid());
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
}
