package aufgabe2;

public class SetApplication {

    public static void main(String[] args) {
        Set s1 = new ArraySet();
        Set s2 = new ArraySet();
        Set s3 = new ArraySet();

        s1.add(1);
        s1.add(5);
        s1.add(8);
		s1.add(0);
        s1.add(5);
        System.out.println(s1); // {1, 5, 8, 0}; andere Reihenfolge ist auch OK.

        for (int i = 1; i <= 50; i++)
            s2.add(2*i);
        System.out.println(s2); // {2, 4, 6, ..., 100}

        s3.add(4);
        s3.add(8);

        // Teilmengenbeziehung pruefen:
		System.out.println(s1.containsAll(s2));  // false
        System.out.println(s1.contains(0));	     // true
        System.out.println(s2.containsAll(s3));  // true
		System.out.println(s2.contains(0));      // false
        System.out.println(s2.containsAll(s2));  // true

        Set s4 = new ArraySet();
        for (int i = 1; i <= 40; i++)
            s4.add(5*i);
        System.out.println(s4); // {5, 10, 15, ..., 200}
		s4.remove(200);
		System.out.println(s4); // {5, 10, 15, ..., 195}

        // Vereinigung:
        s2.addAll(s4);
        System.out.println(s2); // {2, 4, 5, 6, ..., 100, 105, ..., 195}

        // Differenzmenge:
        s2.removeAll(s4); 
		System.out.println(s2); // {2, 4, 6, 8, 12, ..., 98}
		System.out.println(s4); // {5, 10, 15, ..., 195}
		
		// Leere Menge:
		s2.clear();
		System.out.println(s2); // { }
    }
}
