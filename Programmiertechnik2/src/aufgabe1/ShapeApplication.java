package aufgabe1;

public class ShapeApplication {
	
	public static double totalArea(I_Shape[] sa){
		double sum = 0;
		for (I_Shape s : sa) {
			sum += s.getArea();
		}
		return sum;
	}
	
	public static void doAction(short version){
		Point p = new Point(1, 2);
		I_Shape s1 = null;
		I_Shape s2 = null;
		if(version == 1){
			s1 =  new aufgabe1.aufgabe1_1.Ellipse(p);
			s2 =  new aufgabe1.aufgabe1_1.Rectangle(p);	
		}else if(version == 2){
			s1 =  new aufgabe1.aufgabe1_2.Ellipse(p);
			s2 =  new aufgabe1.aufgabe1_2.Rectangle(p);
		}	
		
		System.out.println("Aufgabe1."+version);
		System.out.println(s1+"\n"+s2);
		p.setX(10);
		System.out.println("------ setX(10)");
		System.out.println(s1+"\n"+s2+"\n\n");
		
	}
	
	public static void main(final String[] args){
		
		/*Aufgabe 1*/
		doAction((short)1);
		
		/*Aufgabe1 totalArea test*/
		System.out.println("totalArea demonstration");
		I_Shape[] shapes = new I_Shape[10];
		Point p = new Point(0, 0);
		for(int i = 0; i < shapes.length; ++i){
			if((i%2)==0){
				shapes[i] = new aufgabe1.aufgabe1_1.Rectangle(p);
				System.out.println("added new Rectangle\t to shapes Array");
			}else{
				shapes[i] = new aufgabe1.aufgabe1_1.Ellipse(p);
				System.out.println("added new Ellipse\t to shapes Array");
			}
			shapes[i].setHeight(0+i);
			shapes[i].setWidth(shapes.length-i);
		}
		System.out.println("The sum of all the shape´s areas is: "+ totalArea(shapes)+"\n");
		
		/*Aufgabe 2*/
		doAction((short)2);
		
	}

}
