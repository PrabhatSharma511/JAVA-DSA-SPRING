package DesignPatterns;

public interface Subject {
	
	void addObserver(Observer ob);
	void removeObserver(Observer ob);
	void notifyObserver(String name);

}
