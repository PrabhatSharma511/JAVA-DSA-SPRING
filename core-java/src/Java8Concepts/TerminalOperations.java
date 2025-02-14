package Java8Concepts;

import java.lang.StackWalker.Option;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperations {

	public static void main(String[] args) {
		
		
		//collect-> used to collect elements into another list, set , map etc 
		//takes a collector in paranthesis
		List<Integer> list = Arrays.asList(1,2,3);
		List<Integer> l = list.stream().skip(1).collect(Collectors.toList());
		List<Integer> l2 = list.stream().skip(1).toList();//returns unmodifiable list// introduced in java 16
		System.out.println(l2);
		
		//forEach -> it takes a consumer in paranthesis
		list.stream().forEach(x->System.out.println(x));
		
		//reduce -> combines elements to produce a single result
		//it takes a binary operator i.e a bifunction in paranthesis
		Optional<Integer> oi =  list.stream().reduce((x,y)->x+y);
		System.out.println(oi.get());
		
		//count -> 
		System.out.println(list.stream().count());
		
		//anyMatch, allMatch, noneMatch
		//takes a predicate
		boolean b = list.stream().anyMatch(x->x%2==0);//returns true if any element satisfies the given condition of predicate
		System.out.println(b);
		boolean c = list.stream().allMatch(x->x>0);//returns true if all elements satisfies the given condition of predicate
		System.out.println(c);
		boolean d = list.stream().noneMatch(x->x%2==0);//returns true if no element satisfies the given condition of predicate
		System.out.println(d);
		
		//findfirst findAny
		System.out.println(list.stream().findFirst().get());
		System.out.println(list.stream().findAny().get());
		
		
		//Examples:filter names
		List<String> names = Arrays.asList("Anna","Bob","Charlie","David");
		List<String> nc = names.stream().filter(x->x.length()>3).toList();
		System.out.println(nc);

		//squaring and sorting numbers
		List<Integer> nums = Arrays.asList(5,2,9,1,6);
		System.out.println(nums.stream().map(x->x*x).sorted().collect(Collectors.toList()));
		
		//summing values
		List<Integer> values = Arrays.asList(1,2,3,4,5);
		System.out.println(values.stream().reduce((x,y)->x+y).get());
		System.out.println(values.stream().reduce(Integer::sum).get());//using method reference
		
		//counting occurrence of character
		String str = "Hello World";
		System.out.println(str.chars().filter(x->x=='l').count());
		
		
		List<Integer> numss = List.of(1,2,3,4,5);
		long count = numss.stream().peek(x->System.out.println(x)).count();
		System.out.println(count+" Count");
		
		//min max
		System.out.println("Max: "+Stream.of(1,2,3,4,5).max((o1,o2)->o1-o2)); //comparator can be passed and according to that max will not mean the aximum in all cases it will give result according to comparator
		System.out.println("Min: "+Stream.of(1,2,3,4,5).min(Comparator.naturalOrder()));

		
		//toArray()
		Object[] arr = Stream.of("Alice","Bob","Charlie").toArray();
		System.out.println(arr[0]);
		
		
		//forEachOrdered
		List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
		System.out.println("With foreach");
		numbers.parallelStream().forEach(System.out::println);
		System.out.println("With foreachordered");
		numbers.parallelStream().forEachOrdered(System.out::println);

		
		
		//Streams cannot be reused once a terminal operation has been called on it
		Stream<String> nameStream = names.stream();
		nameStream.forEach(System.out::println);
//		nameStream.map(String::toUpperCase);//gives exception


	}
	
}
