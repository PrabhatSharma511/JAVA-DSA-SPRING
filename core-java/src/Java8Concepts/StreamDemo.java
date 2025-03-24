package Java8Concepts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		//1- streams using collection
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		Stream<Integer> stream = numbers.stream();
		Integer res = numbers.stream().reduce(0, (x,y)->x+y);
		System.out.println(res);
		List<Integer> evenNumbers = numbers.stream().filter(x->x%2==0).collect(Collectors.toList());
		Long count = numbers.stream().filter(x->x%2==0).count();
		List<Integer> numbersSquare = stream.map(x->x*x).collect(Collectors.toList());
		System.out.println(numbersSquare);
		System.out.println(evenNumbers+" "+count);
		System.out.println(res);
		
		//2- streams using Arrays
		String[] arr = {"Apple","Mango","Banana"};
		Stream<String> stringArrayStream = Arrays.stream(arr);
//		System.out.println("Max length String: "+stringArrayStream.max(Comparator.comparingInt(x->x.length())).get());
		System.out.println(stringArrayStream.map(x->x.length()).collect(Collectors.toList()));
		
		//3- streams using Stream.of()
		Stream<Integer> st = Stream.of(1,2,3,4,5);
		System.out.println(st.map(x->x*x*x).collect(Collectors.toList()));
		
		//4- Infinite stream
		Stream<Double> infiniteStream = Stream.generate(()->Math.random());
		//if use .limit() then we can set a limit
		Stream<Double> finiteStream = Stream.generate(()->Math.random()).limit(10);
		finiteStream.forEach(System.out::println);
		
		Stream<Integer> is = Stream.iterate(0,x->x+1).limit(10);
		System.out.println(is.collect(Collectors.toList()));
		


	}
	
}
