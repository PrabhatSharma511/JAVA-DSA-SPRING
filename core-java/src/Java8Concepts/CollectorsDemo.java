package Java8Concepts;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorsDemo {
	
	public static void main(String[] args) {
		//1.Collecting to a list
		List<String> names = Arrays.asList("Alice","Bob","Charlie");
		List<String> fn = names.stream().filter(x->x.startsWith("A")).collect(Collectors.toList());
		System.out.println(fn);
		
		//2.Collecting to a set
		List<Integer> nums = List.of(1,2,2,3,4,4,5);
		Set<Integer> fs = nums.stream().collect(Collectors.toSet());
		System.out.println(fs);
		
		//3.Collecting to a specific collection
		ArrayDeque<Integer> aq = names.stream().collect(Collectors.toCollection(()->new ArrayDeque()));
		List<String> ll = names.stream().collect(Collectors.toCollection(LinkedList::new));
		System.out.println(ll);
		System.out.println(aq.getFirst());

		//4.joining strings
		//concatenates stream elements into a single string
		System.out.println(names.stream().collect(Collectors.joining(", ")));
		
		//5.Summarizing data
		//generates statistical summary(count, sum, min, average, max)
		IntSummaryStatistics stats = nums.stream().collect(Collectors.summarizingInt(x->x));
		System.out.println("stats: "+stats);
		System.out.println(stats.getCount());
		System.out.println(stats.getMax());
		System.out.println(stats.getMin());
		System.out.println(stats.getSum());
		
		//6.calculating average
		Double av = nums.stream().collect(Collectors.averagingInt(x->x));
		System.out.println("Average: "+av);
		
		//7.counting elements		
		System.out.println("count: "+nums.stream().collect(Collectors.counting()));
		
		//8.grouping elements
		List<String> words = Arrays.asList("hello","world","java","streams","collecting");
		System.out.println(words.stream().collect(Collectors.groupingBy(x->x.length())));//returns elements into a map
		System.out.println(words.stream().collect(Collectors.groupingBy(x->x.length(),Collectors.joining(", "))));
		System.out.println(words.stream().collect(Collectors.groupingBy(x->x.length(),Collectors.counting())));//normal map
		System.out.println(words.stream().collect(Collectors.groupingBy(x->x.length(),TreeMap::new,Collectors.counting())));//map sorted by keys that is treemap

		//9.partitioning elements
		//partition elements into two groups(true or false) based on a predicate
		System.out.println(words.stream().collect(Collectors.partitioningBy(x->x.length()>5)));
		System.out.println(words.stream().collect(Collectors.partitioningBy(x->x.length()>5,Collectors.counting())));
		
		//10.Mapping and collecting
		//applies a mapping function before collecting
		System.out.println(words.stream().collect(Collectors.mapping(x->x.toUpperCase(),Collectors.toList())));
		
		//Example-1 Collecting names by length
		List<String> l1 = Arrays.asList("Anna","Bob","Alexander","Brian","Alice");
		System.out.println(l1.stream().collect(Collectors.groupingBy(x->x.length())));//the fn in groupingBy means criteria by which we want to group which is word length in this case

		//Example-2 Counting word occurrences
		String sentence = "hello world hello java world";
		System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting())));//criteria is the words itself
		
		//Example -3 Partitioning even and odd numbers
		List<Integer> l2 = List.of(1,2,3,4,5,6);
		System.out.println(l2.stream().collect(Collectors.partitioningBy(x->x%2==0)));
		
		//Example -4 summing values in a Map
		Map<String,Integer> items = new HashMap<>();
		items.put("Apple",10);
		items.put("Banana", 20);
		items.put("Orange",15);
		System.out.println(items.values().stream().collect(Collectors.summingInt(x->x)));
		System.out.println(items.values().stream().reduce((x,y)->x+y).get());
		
		//Example-5 Creating a map from stream elements
		List<String> fruits = Arrays.asList("Apple","Banana","Cherry");
		System.out.println(fruits.stream().collect(Collectors.toMap(x->x,x->x.length())));

		//Example-6 
		List<String> fruits2 = Arrays.asList("Apple","Banana","Apple","Orange","Banana","Apple");
		System.out.println("Example6: "+fruits2.stream().collect(Collectors.groupingBy(x->x,Collectors.counting())));
		System.out.println("Example6: "+fruits2.stream().collect(Collectors.toMap(x->x,x->1,(x,y)->x+y)));

		
	}

}
