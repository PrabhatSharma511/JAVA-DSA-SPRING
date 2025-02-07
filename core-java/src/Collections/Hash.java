package Collections;

public class Hash {

	public static void main(String[] args) {
		System.out.println(simpleHashFunction("ABC"));//ABC CBA cause hash collision
		System.out.println(simpleHashFunction("CBA"));
	}
	
	public static int simpleHashFunction(String key) {
		int sum = 0;
		for(char c:key.toCharArray()) {
			sum=sum+(int)c;
		}
		return sum%10;
	}
	
}
