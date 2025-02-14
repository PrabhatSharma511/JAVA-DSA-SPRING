package Java8Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Java8Demo {

	public static void main(String[] args) {
		
		MathOperation sum = (a,b)->a+b; //if not lambda then we had to make a class implementing MathOperation interface and in that class write the operate method body then create object of class and call the operate method
		MathOperation diff = (a,b)->a-b;//this is functional programming, treating functins as variables and usinf Interface reference to hold functions
		
		System.out.println(sum.operate(1, 2));
		
		
		//Predicate --> functional interface(boolean valued function)
		Predicate<Integer> isEven = x->x%2==0;
		System.out.println(isEven.test(98));
		Predicate<String> isWordStartingWithA = x->x.toLowerCase().startsWith("a");
		Predicate<String> isWordEndingWithA = x->x.toLowerCase().endsWith("a");
		
		//combining two predicates
		Predicate<String> and = isWordStartingWithA.and(isWordEndingWithA);
		System.out.println(and.test("Asha"));
		
		
		//Function --> functional interface --> works for you through SAM apply(T t) and also returns result R
		Function<Integer,Integer> cube = x->x*x*x;
		Function<Integer,Integer> half = x->x/2;

		//combining two functions
		Function<Integer,Integer> combinedFunctionAndThen =  cube.andThen(half);//first cube applied then half
		Function<Integer,Integer> combinedFunctionCompose =  cube.compose(half);//first half applied then cube

		Function<Integer,Integer> res = Function.identity();//returns a function that returns its input argument
		System.out.println(res.apply(89));
		
		System.out.println(combinedFunctionAndThen.apply(4));
		System.out.println(combinedFunctionCompose.apply(4));
		
		//Consumer -->
		Consumer<Integer> c = (x)->System.out.println(x*2);
		Consumer<Integer> c2 = (x)->System.out.println(x*3);
		
		//combining two consumers
		Consumer<Integer> c3 = c.andThen(c2);
		c3.accept(2);
		
		
		Consumer<List<String>> printList = x->{
			for(String i:x) {
				System.out.println(i);
			}
		};
		List<String> list = Arrays.asList("One","Two","Three");
		printList.accept(list);
		
		
		//Supplier-->
		Supplier<String> s = ()->"Hello World";
		System.out.println(s.get());
		
		//All Combined example
		Predicate<Integer> predicate = x->x%2==0;
		Function<Integer,Integer> function = x->x*x;
		Consumer<Integer> consumer = (x)->System.out.println(x);
		Supplier<Integer> supplier = ()->100;
		
		if(predicate.test(supplier.get())) {
			consumer.accept(function.apply(supplier.get()));
		}
	
		//BiPredicate BiFunction BiConsumer
		BiPredicate<Integer,Integer> isSumEven = (x,y)->(x+y)%2==0;
		System.out.println(isSumEven.test(3,2));
		
		BiFunction<Integer, Integer, Integer> bif = (x,y)->x+y;
		System.out.println(bif.apply(3,4));
		
		BiConsumer<Integer,Integer> bic = (x,y)->System.out.println(x+y);
		bic.accept(2,3);
		
		
		//special function types
		UnaryOperator<Integer> uo = x->x+2; //can be used when in function both argument and result are of same type so no need to write Integer,Integer two times
		System.out.println(uo.apply(1));
		
		//it is a type of function where operands and result have same data type
		BinaryOperator<Integer> bo = (x,y)->x+y;
		System.out.println(bo.apply(89,2)); // for bifunction with same type of operands and result
		
		//Method Reference --> use method without invoking and in place of lamda expression
		List<String> listmf = Arrays.asList("Ram","Shyam","Ghanshyam");
//		listmf.forEach(x->System.out.println(x));
		listmf.forEach(System.out::println);
		
		//Constructor Reference
		List<String> names = List.of("A","B","C");
		List<Mobile> mobilePhones = names.stream().map(Mobile::new).collect(Collectors.toList());
		mobilePhones.forEach(System.out::println);

	}
	
}

class Mobile{
	String name;
	public Mobile(String name) {
		this.name=name;
	}
	@Override
	public String toString() {
		return "Mobile [name=" + name + "]";
	}
	
}

//this is a functional interface
interface MathOperation{
	int operate(int a, int b);
}
