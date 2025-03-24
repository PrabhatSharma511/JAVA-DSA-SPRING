package DesignPatterns;

public class SingletonUsingInnerClass {
	
	private SingletonUsingInnerClass() {
		System.out.println("instance created");
	}
	private static class inner{
		private static final SingletonUsingInnerClass instance = new SingletonUsingInnerClass();
	}
	public static SingletonUsingInnerClass getInstance() {
		return inner.instance;
	}
	
	public static void main(String[] args) {
		SingletonUsingInnerClass s1 = SingletonUsingInnerClass.getInstance();
		SingletonUsingInnerClass s2 = SingletonUsingInnerClass.getInstance();
		int n= 13;
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		
	}

}
