package Hash;

import java.util.HashMap;

public class TicketItenary {

	public static void main(String args[]) {
		HashMap<String,String> map = new HashMap<>();
		map.put("Chennai","Bengaluru");
		map.put("Mumbai","Delhi");
		map.put("Goa","Chennai");
		map.put("Delhi","Goa");
		
		itenary(map);
	}

	private static void itenary(HashMap<String, String> map) {
		//reverseMap to calculate start point
		//the point which is present in keys but not there in value will be start point
		HashMap<String,String> reverseMap = new HashMap<>();
		for(String key:map.keySet()) {
			reverseMap.put(map.get(key),key);
		}
		String start = "";
		for(String mapKey:map.keySet()) {
			if(reverseMap.containsKey(mapKey)==false) {
				start=mapKey;
			}
		}
		while(map.get(start)!=null) {
			System.out.print(start+" -> ");
			start=map.get(start);
		}
		System.out.println(start);
	}
	
}
