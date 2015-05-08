package aufgabe2;


public abstract class AbstractSet implements Set{
	
	protected static int DEFAULT_CAPACITY = 10;
	
	protected int size;
	
	/*INHERITED METHODES - not all but all i think are speaking genral logic, rest of the methodes are to implemented in the extending classes*/
	@Override
	public	int size(){
		return this.size;
	}
	@Override
	public boolean isEmpty(){
		return this.size == 0 ? true : false;
	}
	
	
	/*comfort methods*/
	protected void incrSize(){
		++this.size;
	}
	protected void decrSize(){
		--this.size;
	}
	
	/*DEMANDED TO BE IMPLEMENTED!!!!!!!!!!!!!!!!!*/
	@Override
	public abstract String toString();

}
