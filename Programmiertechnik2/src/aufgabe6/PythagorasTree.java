package aufgabe6;

import aufgabe1.Point;

public class PythagorasTree{

	private static final int MINIMAL_EDGE_LENGTH = 5;
	private static final int PITCH = 30;
	private static final int STANDARD_EDGE_LENGTH = 50;
//	private static final Dimension screenSize;
//	private static final double screenHeight, screenWidth;
//	static{
//		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		screenHeight = screenSize.getHeight();
//		screenWidth = screenSize.getWidth();
//	}
	
	
	private PythagorasTree(){}
	
	
	/*MAIN*/
	public static void main(final String[] args){
		StdDraw.line(0, 100, 100, 100);
		
		drawPythagorasTree();
	}
	
	
	/*IMPORTANT INSTANCEMETHODES*/
	private static void drawPythagorasTree(){
		StdDraw.setPenColor();
		new Point(2, 2);
		drawPythagorasTree(STANDARD_EDGE_LENGTH, new Point(300,300));
	}
	
	private static void drawPythagorasTree(int edgeLength, Point p){
		if(edgeLength <= MINIMAL_EDGE_LENGTH)return;
		
		int newedgeLength = edgeLength-5;
		
		double s,c, u;
		s = edgeLength*Math.sin(PITCH);
		c = edgeLength*Math.cos(PITCH);
		
		Point A, B, C, D, E;
		A = p;
		B = new Point((int)(A.getX()+c), (int)(A.getY()+s));
		C = new Point((int)(A.getX()+c-s), (int)(A.getY()+s+c));
		D = new Point((int)(A.getX()-s), (int)(A.getY()+c));
		
		/*Draw Square*/
		drawLine(A, B);
		drawLine(B, C);
		drawLine(C, D);
		drawLine(D, A);		
		
		u = newedgeLength*Math.sin(PITCH); 
		E = new Point((int)(A.getX()-s+u*Math.cos(2*PITCH)), (int)(A.getY()+c+u*Math.sin(2*PITCH)));
		
		/*Draw Rectangle*/
		drawLine(D, E);
		drawLine(E, C);
		
		
		drawPythagorasTree(newedgeLength, D);
	}
	
	
	private static void drawLine(Point A, Point B){
		StdDraw.line(A.getX(), A.getY(), B.getX(), B.getY());
	}

}
