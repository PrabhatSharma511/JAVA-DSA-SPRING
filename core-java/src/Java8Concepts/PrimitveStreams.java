package Java8Concepts;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitveStreams {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5};
		IntStream stream = Arrays.stream(numbers);
		
		System.out.println(IntStream.range(1, 5).boxed().collect(Collectors.toList()));
		System.out.println(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));

		System.out.println(IntStream.of(9,8,7));
		
		//generate 5 random doubles or ints
		DoubleStream ds = new Random().doubles(5);
//		System.out.println(ds.summaryStatistics());
		System.out.println(ds.mapToInt(x->(int)(x+1)).boxed().toList());
//		System.out.println(ds.max());
//		System.out.println(ds.min());

//		System.out.println(ds.boxed().toList());
		IntStream is = new Random().ints(5);
		
		System.out.println("double: "+is.mapToDouble(x->(double)(x+1)).boxed().toList());

//		System.out.println(is.max().getAsInt());

//		System.out.println(is.boxed().toList());
	}
	
}
