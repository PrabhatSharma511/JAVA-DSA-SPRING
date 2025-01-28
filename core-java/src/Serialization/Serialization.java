package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
	
	public static void main(String[] args) {
		Employee emp = new Employee(1, "Prabhat", "password");
		
		//serialize object
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"));
			oos.writeObject(emp);
			System.out.println("Current working directory: " + System.getProperty("user.dir"));
	        System.out.println("Serialization successful.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
