package Collections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
	private String name;
	private double gpa;
	public Student(String name, double gpa) {
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
}

//class MyComparator implements Comparator<Integer>{
//
//	@Override
//	public int compare(Integer o1, Integer o2) {
//		return o2-o1;
//	}
//	//o1 o2
//	//3,5
//}

//class StringComparator implements Comparator<String>{
//
//	@Override
//	public int compare(String o1, String o2) {
//		return o1.length()-o2.length();
//	}
//	//o1 //o2
//	//"ok" "bye" assume this as u want
//}

public class ArrayListMain {
	
	public static void main(String[] args) throws Exception, Exception {
		
		List<Student> students = new ArrayList<>();
		students.add(new Student("Prabhat3",67));
		students.add(new Student("Prabhat1", 80));
		students.add(new Student("Prabhat2", 84));
		Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed();
		Collections.sort(students,comparator);
//		students.sort((a,b)->(int)(b.getGpa()-a.getGpa()));
		for(Student student:students) {
			System.out.println(student.getName());
		}
		
		ArrayList<Integer> list = new ArrayList<>(20);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1,12);// add 12 at index 1 and move elements ahead
		list.set(0,190);//replace element at index 0 by 190
		list.remove(1);
//		Collections.sort(list);
//		list.sort(new MyComparator());
		list.sort((o1,o2)->o2-o1);//comparator using lambdas
		System.out.println(list);
		
		List<String> words = Arrays.asList("banana","apple","date");
		//if null is passed in sort by default is orders ascending according to alphabet
//		words.sort(new StringComparator());
		words.sort((o1,o2)->o1.length()-o2.length());
		System.out.println(words);
		
//		System.out.println(list.size());
//		for(int x:list) {
//			System.out.println(x);
//		}
//		System.out.println(list.contains(1));
//		System.out.println(list.contains(10));
		
		String[] arr = {"Monday","Tuesday","Sunday"};
		List<String> days = Arrays.asList(arr);
		System.out.println(days.get(2));
//		days.add("Friday"); not possible in list returned for Arrays.asList as it returns fixed size list
		days.set(2, "Saturday");
		System.out.println(days.get(2));
		
		ArrayList<String> daysList = new ArrayList<>(days);
		daysList.add("Friday");
		System.out.println(daysList);
		
		List<Integer> intList = List.of(1,2,3,4,5);
		System.out.println(intList);

		
		
		
		//to get capacity of internal array
		Field field = ArrayList.class.getDeclaredField("elementData");
		field.setAccessible(true);
		Object[] elementData = (Object[])field.get(list);
		System.out.println("ArrayList capacity: "+elementData.length);
		list.trimToSize(); //trims internal capacity to size
		elementData = (Object[])field.get(list);
		System.out.println("ArrayList capacity: "+elementData.length);
		
		

	}

}
