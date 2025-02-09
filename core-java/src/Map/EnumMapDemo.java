package Map;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {

	//array of size same as enum
	//no hashing, ordinal is used
	//faster and memory efficient than hashmap
	public static void main(String[] args) {
		Map<Day,String> map = new EnumMap<>(Day.class);
		map.put(Day.TUESDAY,"FAST");
		map.put(Day.MONDAY,"FAST");
		System.out.println(Day.TUESDAY.ordinal());
		System.out.println(map);
	}
}

enum Day{
	MONDAY, TUESDAY, WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}