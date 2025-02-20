package Java8Concepts;

import java.util.Arrays;
import java.util.Comparator;

public class Practice {

	public static void main(String[] args) {
		String[] arr = {"Tata","BMW","Mahindra","RollsRoyace"};
		System.out.println(Arrays.stream(arr).max(Comparator.comparingInt(x->x.length())).get());
	}

}
