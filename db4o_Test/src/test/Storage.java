package test;

public class Storage {
	private int bla = 0;
	private String name = "blub";
	
	public Storage(int i, String nam){
		bla = i;
		name = nam;
	}
	
	public int getBla() {
		return bla;
	}
	public void setBla(int bla) {
		this.bla = bla;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
