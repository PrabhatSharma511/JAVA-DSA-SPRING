package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualsMethod {
	
	public static void main(String[] args) {
		HashMap<Person,String> persons = new HashMap<>();
		Person p1 = new Person("Alice",1);
		Person p2 = new Person("Bob",2);
		Person p3 = new Person("Alice",1);
		
		persons.put(p1,"Engineer");// hashcode1->index1
		persons.put(p2, "Designer");// hashcode2->index3
		persons.put(p3, "Manager");// hashcode3->index3  after hashcode and equlas overriden hashcode1->index1 -> equals() -> replcae
		
		System.out.println("HashMap Size: "+persons.size());
		System.out.println("p1 value:"+persons.get(p1));
		System.out.println("p3 value:"+persons.get(p3));
		System.out.println(p1);

		
		
		//hashcode generation is related to memory reference so when we create p3 even though it has same values as p1
		//but since a new object is created at new memory it gets a different hashcode
		//while below in case of string hashcode comes same then equals method checks the equality and value is replaces
		//string has its own hashcode method and Student class uses Object class hashcode method
		Map<String,Integer> map = new HashMap<>();
		map.put("Prabhat",80);// hashcode1->index1
		map.put("Rahul",70);// hashcode2->index2
		map.put("Prabaht",90);// hashcode1->index1 -> equals() ->replace 80 by 90

	}

}

class Person{
	private String name;
	private int id;
	
	public Person(String name,int id) {
		this.name=name;
		this.id=id;
	}

	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name,id);
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(this.getClass()!=obj.getClass()) {
			return false;
		}
		Person other = (Person)obj;
		return id==other.getId() && Objects.equals(name, other.getName());
	}

	@Override
	//by default println runs toString method
	public String toString() {
		// TODO Auto-generated method stub
		return "Id: "+id+" Name: "+name;
	}

	
	
}
