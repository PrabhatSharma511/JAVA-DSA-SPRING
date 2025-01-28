package Serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialization {

	public static void main(String[] args) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"));
			Employee emp = (Employee) ois.readObject();;
			System.out.println("Deserialization Successful");
			System.out.println("Deserialized output: "+emp);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
}
