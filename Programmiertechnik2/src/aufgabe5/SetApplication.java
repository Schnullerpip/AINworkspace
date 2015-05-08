package aufgabe5;

public class SetApplication {
	
	public static Object b = new Object();

    public static void main(String[] args) {
        Set<Integer> s1 = new ArraySet<Integer>();
        Set<String> s2 = new ArraySet<String>();
        Set<Number> s3 = new ArraySet<Number>();
        
        for(int i=0;i<100;i++){
        	s1.add(i);
        }
        
        System.out.println("[Set Integer]:\t"+s1);
        
        s2.add("hallo");
        s2.add("mein");
        s2.add("name");
        s2.add("ist");
        s2.add("julian");
        System.out.println("[Set String]:\t"+s2);
        
        s2.removeAll(
        		new ArraySet<String>()
        		.add("name")
        		.add("ist"));
        System.out.println("[Set String]:\t"+s2);
        
        for(double i=0;i<100;i+=0.5){
        	s3.add(i);
        }
        System.out.println("[Set Number]:\t"+s3);
        
        s3.removeAll(s1);
        System.out.println("[Set Number]:\t"+s3);   
    }
}
