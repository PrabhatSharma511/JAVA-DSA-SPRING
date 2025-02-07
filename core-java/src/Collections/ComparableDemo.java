package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Student2 implements Comparable<Student2>{
	private String name;
	private double gpa;
	public Student2(String name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
	}
	public String getName() {
		return name;
	}
	public double getGpa() {
		return gpa;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o==null || getClass()!=o.getClass()) {
			return false;
		}
		Student2 student = (Student2)o;
		return Double.compare(gpa, student.gpa)==0 && Objects.equals(name, student.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,gpa);
	}
	
	//4.compareTo(3)
	@Override
	public int compareTo(Student2 o) {
		return Double.compare(o.getGpa(),this.getGpa());
	}
	@Override
	public String toString() {
		return "Student2 [name=" + name + ", gpa=" + gpa + "]";
	}
	
	
}

public class ComparableDemo {

	public static void main(String[] args) {
		List<Student2> list = new ArrayList<>();
		list.add(new Student2("Charlie",3.5));
		list.add(new Student2("Bob",3.7));
		list.add(new Student2("Alice",3.5));
		list.add(new Student2("Akshit",3.9));
		list.sort(null);
		System.out.println(list);

	}
	
}
