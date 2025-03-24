package DesignPatterns;

public class Subscriber implements Observer{
	
	String subName;
	
	public Subscriber(String name) {
		this.subName=name;
	}

	@Override
	public void notified(String video,String channel) {
		System.out.println("Hello "+ subName+ " New Video Uploaded: "+video +" on "+channel);
	}

}
