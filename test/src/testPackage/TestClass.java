package testPackage;

public class TestClass {
	
	public static void main(final String[] args){
		int[][] mat = new int[3][5];
		
		int p =0;
		for(int i=0;i<5;i++){
			for(int o=0;o<3;o++){
				mat[o][i] = p++;
			}
		}
		System.out.println("bla");
	}
}
