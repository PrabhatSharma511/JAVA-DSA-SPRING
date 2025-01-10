package programming;

import java.util.List;

public class FP01Functional {
	
//	public static void print(int num) {
//		System.out.println(num);
//	}
	
//	public static boolean isEven(int num) {
//		return num%2==0;
//	}

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(19280,12,1,2,32,45,22,11,21);
//		printAllNumbersInListFunctional(numbers);
		printSquares(numbers);

	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		
		numbers.stream()
//		.filter(FP01Functional::isEven)
		.filter(num->num%2==0)
		.forEach(System.out::println);
		
		
		
		
	}
	
	private static void printSquares(List<Integer> numbers) {
		numbers.stream().map(num->num*num).forEach(System.out::println);
	}

}
