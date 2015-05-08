package aufgabe2;

public class ArraySet extends AbstractSet{
	
	protected int[] array;
	
	public ArraySet() {
		clear();
	}
	
	@Override
	public boolean contains(int i){
		for(int o=0; o<size; o++){
			if(array[o] == i){
				return true;
			}
		}	
		return false;
	}
	
	@Override
	public final void clear(){ //final wichtig da konstruktor sich nicht mehr ändern sollte <--> Kann einfach als konstruktor benutzt werden! -> da es werte standardinitialisiert
		size = 0;
		array = new int[DEFAULT_CAPACITY];		
	}
	
	@Override
	public void add(int new_i){
		ensureCapacity();
		if(!contains(new_i)){
			int i;
			for(i=0;i<this.size; i++){ //find the index of the element that is greater than new_i 
				if(new_i < array[i]){
					break;
				}
			}
			//now the index of the right place for the new_i is in i
			for(int o=this.size(); o>i;--o){ //now push all the array elements that are greater than new_i one to the right
				array[o] = array[o-1];
			}
			array[i] = new_i;//finally insert new_i at right position
			incrSize();
		}
	}
	@Override
	public void remove(int to_delete){
		if(contains(to_delete)){ //doppelte iteration eigentlich unschön aber da vorergeben dass contains einen boolean und keinen index zurück gibt naja...
			for(int i=0; i<size; i++){
				if(array[i] == to_delete){
					for(int o=i;o<(size-1);o++){
						array[o] = array[o+1];
					}
					decrSize();
					break;
				}	
			}	
		}
	}
	@Override
	public int get(int index){
		if(index <= size){
			return array[index];
		}
		return -1;
	}
	@Override
	public boolean containsAll(Set s){
		for(int i=0; i<s.size(); i++){
			if(!contains(s.get(i))){
				return false;
			}
		}
		return true;
	}
	@Override
	public void addAll(Set s){
		for(int i=0; i<s.size(); i++){
			if(!contains(s.get(i))){
				add(s.get(i));				
			}			
		}		
	}
	@Override
	public void removeAll(Set s){
		for(int i=0; i<s.size(); i++){
			remove(s.get(i));
		}
	}
	
	
	
	/*INHERITED ABSTRACT METHODE*/
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i=0;i<size;i++){
			sb.append(this.array[i]);
			if((i+1) < size){
				sb.append(", ");
			}
		}
		sb.append("}\n");
		return sb.toString();
	}

	public void ensureCapacity() {
		if(this.size == array.length){
			int[] old = array;
			array = new int[this.size*2];  //create new array with more cpacity
			for(int i=0;i<size; i++){		//copy old array into new one
				array[i] = old[i];
			}
		}
	}
}
