package Java8Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {

	public static void main(String[] args) {
		
		//filter -> it takes a predicate in paranthesis
		List<String> list = Arrays.asList("Ram","Shyam","Shiv","Brahma","Ram");
		Stream<String> filteredStream = list.stream().filter(x->x.startsWith("P"));
		//no filtering applied till this point as terminal operation not applied
		long num = filteredStream.count();
		System.out.println(num);
		
		//map -> it takes a function in paranthesis
		Stream<String> fs = list.stream().map(x->x.toUpperCase());
		List<String> ls = fs.collect(Collectors.toList());
		System.out.println(ls);
		
		//sorted -> it can take a comparator otherwise natural sorting
		Stream<String> sortedList = list.stream().sorted();
		System.out.println(sortedList.collect(Collectors.toList()));
		Stream<String> sortedListWithComparator = list.stream().sorted((x,y)->x.length()-y.length());
		System.out.println(sortedListWithComparator.collect(Collectors.toList()));
		
		//distinct -> returns distinct elements and checks according to equals
		System.out.println(list.stream().filter(x->x.equals("Ram")).distinct().collect(Collectors.toList()));

		//limit -> to set number of results required
		System.out.println(Stream.iterate(1,x->x+1).limit(10).collect(Collectors.toList()));
		
		//skip -> to skip some elements, although limit is 10 on infinite stream so 10 elements will be returned
		System.out.println(Stream.iterate(1,x->x+1).skip(3).limit(10).collect(Collectors.toList()));

		//peek ->performs an action on each element as it is consumed
		Stream.iterate(1,x->x+1).skip(3).limit(10).peek(System.out::println).count();
		List<Integer> nums = List.of(1,2,3,4,5);
		nums.stream()
	    .filter(x -> x % 2 == 0)
	    .peek(x -> System.out.println("Filtered: " + x))
	    .map(x -> x * 2)
	    .forEach(System.out::println);
		
		//flatMap
		//Handles streams of collections, lists, or arrays where each element is itself a collection
		//flatten nested structures(e.g lists within lists) so that they can be processed as a single sequence of elements
		//transform and flatten elements at the same time
		List<List<String>> listOfLists = Arrays.asList(
				Arrays.asList("Apple","Banana"),
				Arrays.asList("Orange","Kiwi"),
				Arrays.asList("Pear","Grape")
				);
		
		System.out.println(listOfLists.stream().flatMap(x->x.stream()).map(String::toUpperCase).toList());
		
		List<String> sentences = Arrays.asList(
				"Hello World",
				"Java Streams are powerful",
				"flatmap is useful"
				);
		System.out.println(sentences.stream().flatMap(sen->Arrays.stream(sen.split(" "))).map(x->x.toUpperCase()).toList());
		
		
 	}
	
}
