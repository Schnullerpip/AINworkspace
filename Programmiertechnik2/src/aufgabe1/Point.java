package aufgabe1;

public class Point {
	
	private double x;
	private double y;
	
	public Point(double a, double b){
		this.x = a;
		this.y = b;
	}
	
	@Override
	public String toString() {
		return "X: "+x+"; Y: "+y;};
		
	@Override
	public Point clone() throws CloneNotSupportedException {
		return new Point(this.x, this.y);
	};
	
	
	
	/*GETTERS AND SETTERS*/
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	

}
