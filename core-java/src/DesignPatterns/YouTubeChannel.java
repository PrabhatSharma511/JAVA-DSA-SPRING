package DesignPatterns;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject{
	
	List<Observer> subscribers = new ArrayList<>();
	String name;
	
	public YouTubeChannel(String name) {
		this.name=name;
	}

	@Override
	public void addObserver(Observer ob) {
		subscribers.add(ob);
	}

	@Override
	public void removeObserver(Observer ob) {
		subscribers.remove(ob);
	}

	@Override
	public void notifyObserver(String videoName) {
		for(Observer sub: subscribers) {
			sub.notified(videoName,this.name);
		}
	}
	
	public void uploadVideo(String name) {
		notifyObserver(name);
	}
	

}
