package generics;

public class GenericMethods {

	public static void main(String[] args) {
		Integer[] arr = {1,3,4,2,6};
		String[] arrs = {"hello","world","java"};
		printArray(arr);
		printArray(arrs);

	}
	
	public static <T> void printArray(T[] arr) {
		for(T ele:arr) {
			System.out.println(ele);
		}
	}
	
}
