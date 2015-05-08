package aufgabe1;



public interface I_Shape {
	void setCenter(Point p);	//setzt den Flächenschwerpunkt
	Point getCenter();			//liefert den Flächenschwerpunkt zurück
	void setWidth(double d);	//setzt die Breite
	double getWidth();			//liefert die Breite zurück	
	void setHeight(double d);	//setzt die Höhe
	double getHeight(); 		//liefert die Höhe zurück	
	double getArea();			//liefert den Flächeninhalt zurück
}
