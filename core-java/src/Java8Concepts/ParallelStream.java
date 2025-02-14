package Java8Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {
	
	public static void main(String[] args) {
		//type of stream that enables parallel processing
		long start = System.currentTimeMillis();
		List<Integer> list = Stream.iterate(1,x->x+1).limit(20000).toList();
		List<Integer> factorialList = list.stream().map(x->factorial(x)).toList();
		long end = System.currentTimeMillis();
		System.out.println("Time taken with sequential stream: "+(end-start));
		
		start = System.currentTimeMillis();
		factorialList = list.parallelStream().map(x->factorial(x)).toList();
		end = System.currentTimeMillis();
		System.out.println("Time taken with parallel stream: "+(end-start));
		
		//cumulative sum
		//[1,2,3,4,5] -> [1,3,6,10,15]
		//in this result does not come as expected because it is not independent so parallel stream cannot be used in this case
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		AtomicInteger sum = new AtomicInteger();
		List<Integer> cumulativeSum = numbers.parallelStream().map(x->sum.addAndGet(x)).toList();
		System.out.println(cumulativeSum);

		//forEachOrdered
		List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,10);
		System.out.println("With foreach");
		nums.parallelStream().forEach(System.out::println);
		System.out.println("With foreachordered");
		nums.parallelStream().forEachOrdered(System.out::println);
	}
	
	public static int factorial(int n) {
		if(n==1 || n==0) {
			return 1;
		}
		return n*factorial(n-1);
	}

}
