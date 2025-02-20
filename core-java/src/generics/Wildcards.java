package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcards {
	
	public static void main(String[] args) {
		System.out.println(sum(Arrays.asList(1,2.2,3)));
	}

	//upper bound
	public static double sum(List<? extends Number> arr) {
		double sum = 0;
		for(Number a:arr) {
			sum=sum+a.doubleValue();
		}
		return sum;
	}
	
	//lower bound
	public static void printNumbers(List<? super Integer> list) {
		for(Object a: list) {
			System.out.println(a);
		}
	}
}
