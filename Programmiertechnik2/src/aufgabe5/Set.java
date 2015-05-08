package aufgabe5;

public interface Set<T> {
    int size();						//liefert die Anzahl der Elemente der Menge zurück
    boolean isEmpty();				//prüft, ob die Menge leer ist
    Set<T> add(T x);				//fügt das Element x zur Menge dazu
    								//(nur falls x nicht schon in der Menge vorkommt
    void remove(Object x);				//löscht das Element x in
    								//der Menge 
    boolean contains(Object x);			//prüft, ob das Element x in der Menge vorkommt.
    T get(int i);					//liefert das i
    								//te Element aus der Menge zurück.
    								//Beachte, dass 0 <= i < size() sein muss.
    boolean containsAll( Set<? extends T> s);	//Prüft, ob alle Elemente aus s in der Menge vorkommen(Teilmenge)
    void addAll(Set<? extends T>s);				//Fügt alle Elemente aus s zur Menge dazu (Vereinigung)
    void removeAll(Set<? extends T> s);			//Löscht alle Elemente aus s aus der Menge (Differenzmeng
    void clear();					//Löscht alle Elemente der Menge
}