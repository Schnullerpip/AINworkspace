package aufgabe1.aufgabe1_1;

import aufgabe1.I_Shape;
import aufgabe1.Point;

public class Ellipse implements I_Shape{
	
	private Point center;
	private double width;
	private double height;
	
	/*CONSTRUCTOR*/
	public Ellipse(Point p) {
		/*in order to maintain a stable point even when p is changed we copy the old Point*/
		try {
			this.center = p.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e + "clone could not be made...\n");
		}
	}
	
	/*INHERITTED METHODES*/
	@Override
	public String toString(){
		return "X: "+center.getX()+"\tY: "+center.getY()+"\twidth: "+width+"\theight: "+height;
	}
	
	@Override
	public void setCenter(Point p) {
		center = p;
	}

	@Override
	public Point getCenter() {
		return center;
	}

	@Override
	public void setWidth(double d) {
		width = d;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public void setHeight(double d) {
		height = d;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public double getArea() {
		return Math.PI/4*height*width;
	}

}
