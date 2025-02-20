package generics;

enum Operations{
	ADD,SUBTRACT,DIVIDE,MULTIPLY;
	
	public <T extends Number> Double apply(T a,T b) {
		switch(this) {
		case ADD:
			return a.doubleValue()+b.doubleValue();
		case SUBTRACT:
			return a.doubleValue()-b.doubleValue();
		case DIVIDE:
			return a.doubleValue()/b.doubleValue();
		case MULTIPLY:
			return a.doubleValue()*b.doubleValue();
		default:
			throw new AssertionError("Unknown operation: "+this);
		
		}
	}
}

public class Main2 {

	public static void main(String[] args) {
		Box<Integer> box = new Box<>();//box is now type safe
		box.setValue(1);
				
//		String i = (String)(box.getValue());
		int i = box.getValue();
		System.out.println(i);
		
		Pair<String,Integer> p = new Pair<String, Integer>("Age",17);
		System.out.println(p.getKey());
		System.out.println(p.getValue());
		
		System.out.println(Operations.DIVIDE.apply(12,2));

	}
	
}
