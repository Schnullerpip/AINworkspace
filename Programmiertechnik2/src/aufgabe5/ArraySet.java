package aufgabe5;

public class ArraySet<T> extends AbstractSet<T>{
	
	protected T[] array;
	
	public ArraySet() {
		clear();
	}
	
	@Override
	public boolean contains(Object i){
		if(i instanceof Number){
			i = ((Number) i).doubleValue();
		}
		for(int o=0; o<size; o++){
			if(i instanceof Number){
				if(((Number)array[o]).doubleValue() == (double)i){
					return true;
				}
			}
			if(array[o].equals(i)){
				return true;
			}
		}	
		return false;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public final void clear(){ //final wichtig da konstruktor sich nicht mehr ändern sollte <--> Kann einfach als konstruktor benutzt werden! -> da es werte standardinitialisiert
		size = 0;
		array = (T[])new Object[DEFAULT_CAPACITY];		
	}
	
	@Override
	public Set<T> add(T new_i){
		ensureCapacity();
		if(!contains(new_i)){
			array[size++] = new_i;
		}
		return this;
	}
	
	@Override
	public void remove(Object to_delete){
		if(contains(to_delete)){ //doppelte iteration eigentlich unschön aber da vorergeben dass contains einen boolean und keinen index zurück gibt naja...
			for(int i=0; i<size; i++){
				if(to_delete instanceof Number){
					to_delete = ((Number) to_delete).doubleValue();
					if(((Number)array[i]).doubleValue() == (double)to_delete){
						for(int o=i;o<(size-1);o++){
							array[o] = array[o+1];
						}
						decrSize();
						break;
					}
				}
				if(array[i].equals(to_delete)){
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
	public T get(int index){
		if(index <= size){
			return array[index];
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean containsAll( @SuppressWarnings("rawtypes") Set s){
		for(int i=0; i<s.size(); i++){
			if(!contains((T)s.get(i))){
				return false;
			}
		}
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void addAll(@SuppressWarnings("rawtypes") Set s){
		for(int i=0; i<s.size(); i++){
			if(!contains((T)s.get(i))){
				add((T)s.get(i));				
			}			
		}		
	}
	@SuppressWarnings("unchecked")
	@Override
	public void removeAll(@SuppressWarnings("rawtypes") Set s){
		for(int i=0; i<s.size(); i++){
			remove((T)s.get(i));
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

	@SuppressWarnings("unchecked")
	public void ensureCapacity() {
		if(this.size == array.length){
			T[] old = array;
			array = (T[])new Object[this.size*2];  //create new array with more cpacity
			for(int i=0;i<size; i++){				//copy old array into new one
				array[i] = old[i];
			}
		}
	}
}
