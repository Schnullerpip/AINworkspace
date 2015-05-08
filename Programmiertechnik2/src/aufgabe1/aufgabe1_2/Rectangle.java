package aufgabe1.aufgabe1_2;

import aufgabe1.Point;

public class Rectangle extends A_Shape{
	
	/*CONSTRUCTOR*/
	public Rectangle(Point p) {
		/*in order to maintain a stable point even when p is changed we copy the old Point*/
		try {
			this.center = p.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e + "clone could not be made...\n");
		}
	}

	@Override
	public double getArea() {
		return this.height*this.width;
	}

}
