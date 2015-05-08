package aufgabe1.aufgabe1_2;

import aufgabe1.Point;

public class Ellipse extends A_Shape{
	
	/*CONSTRUCTOR*/
	public Ellipse(Point p) {
		/*in order to maintain a stable point even when p is changed we copy the old Point*/
//		try {
//			this.center = p.clone();
//		} catch (CloneNotSupportedException e) {
//			System.out.println(e + "clone could not be made...\n");
//		}
		this.center = p;
	}

	@Override
	public double getArea() {
		return Math.PI/4*height*width;
	}

}
