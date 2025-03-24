package Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Chceckingcc {
	
	public static void main(String[] args) {
		Employee e1 = new Employee("Ram",120000);
		Employee e2 = new Employee("Shyam",130000);
		Employee e3 = new Employee("Prabhat",100000);
		
		List<Employee> e = Arrays.asList(e1,e2,e3);
		System.out.println(e);
		Collections.sort(e);
		for(int i =0;i<e.size();i++) {
			System.out.println(e.get(i).getName());
		}
		
		
	}

}

class Employee implements Comparable<Employee>{
	String name;
	int salary;
	
	public Employee(String name,int salary) {
		this.name=name;
		this.salary=salary;
	}

	@Override
	public int compareTo(Employee o) {
		if(this==null || o==null) {
			throw new NullPointerException();
		}
		return Integer.compare(this.salary,o.salary);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee{name='" + name + "', salary=" + salary + "}";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}