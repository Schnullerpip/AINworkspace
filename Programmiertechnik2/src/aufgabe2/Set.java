package aufgabe2;

public interface Set {
    int size();						//liefert die Anzahl der Elemente der Menge zurück
    boolean isEmpty();				//prüft, ob die Menge leer ist
    void add(int x);				//fügt das Element x zur Menge dazu
    								//(nur falls x nicht schon in der Menge vorkommt
    void remove(int x);				//löscht das Element x in
    								//der Menge 
    boolean contains(int x);		//prüft, ob das Element x in der Menge vorkommt.
    int get(int i);					//liefert das i
    								//te Element aus der Menge zurück.
    								//Beachte, dass 0 <= i < size() sein muss.
    boolean containsAll(Set s);		//Prüft, ob alle Elemente aus s in der Menge vorkommen(Teilmenge)
    void addAll(Set s);				//Fügt alle Elemente aus s zur Menge dazu (Vereinigung)
    void removeAll(Set s);			//Löscht alle Elemente aus s aus der Menge (Differenzmeng
    void clear();					//Löscht alle Elemente der Menge
}