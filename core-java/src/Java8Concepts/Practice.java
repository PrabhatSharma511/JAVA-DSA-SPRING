package Java8Concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {
	
	 public static void reverseArray(int arr[]) {
	        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
	         Collections.reverse(list);
	         for (int i = 0; i < arr.length; i++) {
	            arr[i] = list.get(i);
	        }
	    }

	public static void main(String[] args) {
		String[] arr = {"Tata","BMW","Mahindra","RollsRoyace"};
		System.out.println(Arrays.stream(arr).max(Comparator.comparingInt(x->x.length())).get());
		System.out.println(Arrays.stream(arr).sorted((o1,o2)->o2.length()-o1.length()).skip(1).findFirst());
		
		
		
		int[] a = {3,1,5,7,8,4,2};
		//finding 2nd highest in a
		System.out.println(Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst());
		
		List<int[]> ra = Arrays.asList(a);
//		Collections.sort(ra,Collections.reverseOrder());
		Collections.reverse(ra);
		Arrays.sort(a);
		System.out.println(a[0]);
		reverseArray(a);
		System.out.println(a[0]);
		
//		Q1 - Using streams, how would you get the sum of all numbers in the list?
		List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
		System.out.println(numbers.stream().reduce((x,y)-> x+y).get());
//		Alternative: You could also use .reduce(0, Integer::sum) to avoid .get().
		
//		Q2 - Using streams, how would you create a list of names in uppercase?
		List<String> names = Arrays.asList("alice", "bob", "charlie", "david");
		System.out.println(names.stream().map(x->x.toUpperCase()).toList());
		
//		Q3 - Using streams, how would you get the names of students who scored more than 80?
		Map<String, Integer> scores = Map.of("John", 85, "Jane", 92, "Jack", 76);
		System.out.println(scores.entrySet().stream().filter(x->x.getValue()>80).map(x->x.getKey()).toList());
		
//		Q4 - Using streams, how would you find the maximum value in the array?
		int[] arrr = {3, 6, 2, 8, 5, 10};
		System.out.println(Arrays.stream(arrr).boxed().max(Comparator.naturalOrder()).get());
		
//		Q5 - Using streams, how would you count how many words start with "a"?
		List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry");
		System.out.println(words.stream().filter(x->x.startsWith("a")).count());
		
//		Q6 - Using streams, how would you create a list containing only the strings with length greater than 1, sorted in reverse order?
		List<String> items = Arrays.asList("a", "bb", "ccc", "dd", "e");
		System.out.println(items.stream().filter(x->x.length()>1).sorted(Comparator.reverseOrder()).toList());
		
//		Q7 - Using streams, how would you join all the animal names into a single string separated by commas?
		List<String> animals = Arrays.asList("dog", "cat", "elephant", "tiger", "cow");
		System.out.println(animals.stream().collect(Collectors.joining(",")));
		
//		Q7 - Using streams, how would you check if any name starts with "B"?
		List<String> namess = Arrays.asList("Anna", "Bob", "Ankit", "Brian");
		System.out.println(names.stream().anyMatch(x->x.toUpperCase().startsWith("B")));
		
//		Q8 - Using streams, how would you get the first fruit that has 6 letters?
		List<String> fruits = Arrays.asList("mango", "apple", "banana", "orange");
		System.out.println(fruits.stream().filter(x->x.length()==6).findFirst().get());
		
//		Q9 - Using streams, how would you sort the list in ascending order and skip the first 2 elements?
		List<Integer> nums = Arrays.asList(5, 3, 8, 6, 2);
		System.out.println(nums.stream().sorted().skip(2).toList());
		
//		Q10 - Using streams, how would you find the longest name?
		List<String> namesss = Arrays.asList("Mike", "Anna", "Tom", "Bob", "Alice");
		System.out.println(namesss.stream().sorted((o1,o2)->o2.length()-o1.length()).findFirst().get());
		
//		Q11 - Using streams, how would you group the strings by their first letter into a Map<Character, List<String>>?
		List<String> data = Arrays.asList("apple", "banana", "avocado", "blueberry", "apricot");
		System.out.println(data.stream().collect(Collectors.groupingBy(x->x.charAt(0))));
		
//		Q12 - Using streams, how would you partition the list into two groups: strings with length > 2 and strings with length ≤ 2? Return a Map<Boolean, List<String>>.
		List<String> itemsS = Arrays.asList("a", "bb", "ccc", "dd", "e", "ffff");
		System.out.println(itemsS.stream().collect(Collectors.partitioningBy(x->x.length()>2)));
		
//		Q13 - Using streams, how would you flatMap the characters of all words into a single list of characters?
		List<String> wordss = Arrays.asList("cat", "dog", "bat");
		System.out.println(
			    wordss.stream()
			          .flatMap(x -> x.chars().boxed().map(y -> (char) y.intValue()))
			          .toList()
			);	
		
//		Q14 - Using streams, how would you get the total sum of all values in the map?
		Map<String, Integer> stock = new HashMap<>();
		stock.put("apple", 10);
		stock.put("banana", 5);
		stock.put("orange", 8);
		System.out.println(stock.values().stream().collect(Collectors.summingInt(x->x)));
		
//		Q15 - Using streams, how would you find the second longest string in the list?
		List<String> list = Arrays.asList("java", "python", "c++", "go", "ruby");
		System.out.println(list.stream().sorted((o1,o2)->o2.length()-o1.length()).skip(1).findFirst().get());

//		Q16 - Using streams, how would you check if all numbers are odd? Return true/false.
		List<Integer> numss = Arrays.asList(3, 5, 7, 9, 11, 13);
		System.out.println(numss.stream().allMatch(x->x%2!=0));
		
//		Q17 - Using streams, how would you get a list of all words (split by space) in a single flat list?
		List<String> lines = Arrays.asList("hello world", "java streams", "advanced tricks");
		System.out.println(lines.stream().flatMap(x->Arrays.stream(x.split(" "))).toList());
		
//		Q18 - Using streams, how would you convert this into a comma-separated string like "2,4,6,8,10"?
		List<Integer> numberss = Arrays.asList(2, 4, 6, 8, 10);
		System.out.println(numberss.stream().map(x->x.toString()).collect(Collectors.joining(", ")));
		
//		Q19 - Using streams, group the strings by their length and count how many strings fall into each length. Return a Map<Integer, Long>
		List<String> dataa = Arrays.asList("one", "two", "three", "four", "five", "six");
		System.out.println(dataa.stream().collect(Collectors.groupingBy(x->x.length(),Collectors.counting())));
		
//		Q20 - Using streams, calculate the average of the numbers (as a double).
		List<Integer> numbersss = Arrays.asList(10, 20, 30, 40, 50);
		System.out.println(numbersss.stream().collect(Collectors.averagingDouble(x->x)));

//		Q21 - Using streams, group the strings by their first character and collect them into a Map<Character, List<String>>.
		List<String> liist = Arrays.asList("apple", "banana", "cherry", "avocado", "blueberry");
		System.out.println(liist.stream().collect(Collectors.groupingBy(x->x.charAt(0))));
		
//		Q22 - Using streams, find the entry with the maximum value and return it as a Map.Entry<String, Integer>.
		Map<String, Integer> sttock = new HashMap<>();
		sttock.put("apple", 50);
		sttock.put("banana", 30);
		sttock.put("orange", 20);
		System.out.println(sttock.entrySet().stream().sorted((o1,o2)->o2.getValue()-o1.getValue()).findFirst());
		
//		Q23 - Using streams, find the total number of characters in all strings combined.
		List<String> worrds = Arrays.asList("stream", "api", "java", "lambda", "function");
		System.out.println(worrds.stream().map(x->x.toCharArray().length).reduce((x,y)->x+y));
		System.out.println(worrds.stream().mapToInt(x->x.length()).sum());
		
//		Q24 - Using streams, create a single string where each word is in uppercase and separated by a hyphen -.
		List<String> wwords = Arrays.asList("java", "python", "c++", "ruby", "go");
		System.out.println(wwords.stream().map(x->x.toUpperCase()).collect(Collectors.joining("-")));

		List<String> phrases = Arrays.asList("hello world", "java streams", "advanced tricks");

		System.out.println(phrases.stream().flatMap(x->Arrays.stream(x.split(" "))).collect(Collectors.toList()));






















		
	
	}

}
