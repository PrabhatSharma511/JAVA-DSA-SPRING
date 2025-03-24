package DesignPatterns;

public class ObserverPatternMain {
	
	public static void main(String[] args) {
		YouTubeChannel channel = new YouTubeChannel("Tech Channel");
		YouTubeChannel channe2 = new YouTubeChannel("Music channel");

		Subscriber s1 = new Subscriber("Prabhat");
		Subscriber s2 = new Subscriber("MusicLover");
		
		channe2.addObserver(s2);

		channel.addObserver(s1);
		channel.addObserver(s2);

		channe2.uploadVideo("Brown Rang - Yo Yo Honey Singh Full HD video song");
		channel.uploadVideo("Coding");
	}

}
