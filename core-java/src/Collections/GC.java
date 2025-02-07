package Collections;

import java.lang.ref.WeakReference;

public class GC {
	
	public static void main(String[] args) {
//		Phone phone = new Phone("Samsung","S21FE"); //creating object like this is strong reference
//		System.out.println(phone);
//		phone=null;
//		System.out.println(phone);
		WeakReference<Phone> weakReferencePhone = new WeakReference<Phone>(new Phone("Samsung","S25+"));
		System.out.println(weakReferencePhone.get());
		System.gc();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(weakReferencePhone.get());

		
	}

}

class Phone{
	String brand;
	String model;
	public Phone(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
	}
	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", model=" + model + "]";
	}
	
	
}
