package aufgabe1.aufgabe1_2;

import aufgabe1.I_Shape;
import aufgabe1.Point;

public abstract class A_Shape implements I_Shape{
	
	protected Point center;
	protected double width;
	protected double height;
	
	
	/*INHERITTED METHODES*/

	@Override
	public abstract double getArea();
	
	
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

}
