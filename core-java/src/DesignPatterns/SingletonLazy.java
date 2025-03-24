package DesignPatterns;

public class SingletonLazy {
	
	private static SingletonLazy instance;
	
	private SingletonLazy() {};
	
	public static synchronized SingletonLazy getInstance() {
		if(instance==null) {
			instance=new SingletonLazy();
			return instance;
		}else {
			return instance;
		}
	}
	
	public static void main(String[] args) {
		SingletonLazy s1 = SingletonLazy.getInstance();
		SingletonLazy s2 = SingletonLazy.getInstance();
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}

}
