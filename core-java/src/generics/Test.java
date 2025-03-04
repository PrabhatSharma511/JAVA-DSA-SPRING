package generics;

enum Days{
	SUNDAY,MONDAY,TUESDAY
}

public class Test {
	
	public static void main(String[] args) {
		MyNumber mn = new MyNumber(3);
		Boxx<MyNumber> b = new Boxx(mn);
		b.display();;
		Days day = Days.MONDAY;
//		Days d = "MONDAY";//GIVES ERROR SO ENUM ARE TYPE SAFE BY DEFAULT
	}

}

interface Printable{
	void print();
}

class MyNumber extends Number implements Printable{
	private final int value;
	
	public MyNumber(int value) {
		this.value=value;
	}

	@Override
	public void print() {
		System.out.println("MyNumber: "+value);
	}

	@Override
	public int intValue() {
		return value;
	}

	@Override
	public long longValue() {
		return value;
	}

	@Override
	public float floatValue() {
		return value;
	}

	@Override
	public double doubleValue() {
		return value;
	}
	
}


class Boxx<T extends Number & Printable>{
	private T item;

	public Boxx(T item) {
		this.item = item;
	}
	
	public void display() {
		item.print();
	}
	
	public T getItem() {
		return item;
	}
	
}