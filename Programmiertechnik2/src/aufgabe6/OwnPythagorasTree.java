package aufgabe6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OwnPythagorasTree extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int PITCH = 30;
	private static final Dimension screen = Toolkit.getDefaultToolkit()
			.getScreenSize();
	private static final int STANDARD_EDGE_LENGTH = 100;
	private static final int MINIMAL_EDGE_LENGTH = 1;

	public OwnPythagorasTree() {
		setSize((int) screen.getWidth(), (int) screen.getHeight());
	}
	
	public static void main(final String[] args){
		JFrame frame = new JFrame();
		frame.setTitle("Pythagoras Tree Application");
		frame.setLocationRelativeTo(null);
		frame.setSize(screen.width, screen.height);
		frame.setContentPane(new OwnPythagorasTree());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	/*CRITICAL OVERWRITE OF PAINTCOMPONENT*/
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		drawPythagorasTree(g);
	}

	public void drawPythagorasTree(Graphics g) {
		Point p = new Point(300, 300);
		
		drawPythagorasTree(g, STANDARD_EDGE_LENGTH, p, 0, false);

	}

	public void drawPythagorasTree(Graphics g, int edge, Point p, int depth, boolean rightTree) {
		if (edge <= MINIMAL_EDGE_LENGTH || depth >= 5)
			return;
		
		double s, c, newedge, sin, cos;
		sin = Math.sin(Math.toRadians(PITCH*depth));
		cos = Math.cos(Math.toRadians(PITCH*depth));
		newedge = edge * Math.cos(Math.toRadians(PITCH));
		c = cos*newedge;
		s = newedge * sin;

		Point A, B, C, D;
		A = p;
		B = new Point((int) (A.x+c),   (int) (A.y-s));
		C = new Point((int) (A.x+c-s), (int) (A.y-s-c));
		D = new Point((int) (A.x-s),   (int) (A.y-c));
		
		/*Write Points
		g.drawString("A", A.x, A.y);
		g.drawString("B", B.x, B.y);
		g.drawString("C", C.x, C.y);
		g.drawString("D", D.x, D.y);
		g.drawString("E", E.x, E.y);
	
		/*Draw Square*/
		drawLine(g, A, B);
		drawLine(g, B, C);
		drawLine(g, C, D);
		drawLine(g, D, A);

		/*Draw Rectangle*/
		//drawLine(g, E, C);

		drawPythagorasTree(g, (int)newedge, D, depth+1, false);
		drawPythagorasTree(g, (int)(sin*edge), B, depth+1, true);
	}
	
	private void drawLine(Graphics g, Point A, Point B){
		g.drawLine(A.x, A.y, B.x, B.y);
	}

	class Point {
		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
