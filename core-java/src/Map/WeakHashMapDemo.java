package Map;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
	
	public static void main(String[] args) {
		WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
		
//		imageCache.put(new String("img1"),new Image("Image1"));
//		imageCache.put(new String("img2"),new Image("Image2"));
		
		loadCache(imageCache);
		System.out.println(imageCache);
//		key1=null;
//		key2=null;
		System.gc();
		simulateApplicationRunning();
		System.out.println("After app run, some enries might be cleared"+imageCache);

	}

	private static void loadCache(Map<String, Image> imageCache) {
		//since scope of key1 and key2 is upto this method only
		//we do not need to set it null
		//JVM can clear it as keys are not strong referenced in main method where gc is clearing
		//using in main method directly pass  new String("img1") in map.put
		//as reference key1/key2 not created so it is considered weak and works
		String key1= new String("img1");
		String key2= new String("img2");
		imageCache.put(key1,new Image("Image1"));
		imageCache.put(key2,new Image("Image2"));
		
	}

	private static void simulateApplicationRunning() {
		try {
			System.out.println("Simulating Application Running");
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}



class Image{
	String name;

	public Image(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return name ;
	}
	
	
}
