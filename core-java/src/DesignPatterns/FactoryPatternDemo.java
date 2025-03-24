package DesignPatterns;

public class FactoryPatternDemo {
	
	public static void main(String[] args) {
		Shape s = ShapeFactory.createShape(ShapeType.CIRCLE);
		s.draw();
		Shape s2 = ShapeFactory.createShape(ShapeType.RECTANGLE);
		s2.draw();
	}

}
