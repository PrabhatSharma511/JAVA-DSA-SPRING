package practice_any;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumerals {
	
	public static void main(String[] args) {
		int n = 19;
		StringBuilder sb = new StringBuilder();
		Map<Integer,String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        
        
        for(Map.Entry<Integer,String> entry : map.entrySet()) {
        	while(n>=entry.getKey()) {
        		sb.append(entry.getValue());
        		n=n-entry.getKey();
        	}
        }
        System.out.println(sb.toString());
		
	}

}
