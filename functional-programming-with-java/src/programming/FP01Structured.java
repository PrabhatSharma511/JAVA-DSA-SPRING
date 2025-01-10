package programming;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,1,2,32,45,22,11,21);
//		printAllNumbersInListStructured(numbers);
		printAllEvenNumbersInListStructured(numbers);

	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		
		for(int number : numbers) {
			System.out.println(number);
		}
		
	}
	
	private static void printAllEvenNumbersInListStructured(List<Integer> numbers) {
		
		for(int number : numbers) {
			if(number%2==0) {
				System.out.println(number);
			}
			
		}
		
	}

}
