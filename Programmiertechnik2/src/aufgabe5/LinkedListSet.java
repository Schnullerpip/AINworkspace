package aufgabe5;

public class LinkedListSet<T> extends AbstractSet<T>{
	
	private Node head;
	
	
	/*CONTRUCTOR*/
	public LinkedListSet(){
		clear();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<T> add(Object x) {
		Node p = head;
		
		if(contains(x)){
			return this;
		}
		
		if(isEmpty()){
			p.next = new Node((T)x);
			incrSize();
			return this;
		}
		
		while(p.next != null){
			p = p.next;
		}
		p.next = new Node((T)x, p.next);
		incrSize();
		
		return this;
		
	}

	@Override
	public void remove(Object x) {
		Node p = head;
		
		while(p.next != null){
			if(p.next.volume == x){
				p.next = (p.next.next);
				decrSize();
				return;
			}
			p = p.next;
		}
	}

	@Override
	public boolean contains(Object x) {
		Node p;
		for(p = head; p.next != null; p = p.next){
			if(p.next.volume.equals(x)){
				return true;
			}
		}
		return false;
	}

	@Override
	public T get(int i) {
		Node p = head.next;
		for(int index=0;index<i;++index){
			p = p.next;
		}
		return p.volume;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean containsAll( Set s) {		
		for(int i=0;i<s.size();++i){
			if(!contains(s.get(i))){
				return false;
			}
		}
		return true;
	}

	
	@Override
	@SuppressWarnings("rawtypes")
	public void addAll(Set s) {
		for(int i=0;i<s.size();++i){
			add(s.get(i));
		}
	}
	

	@Override
	@SuppressWarnings("rawtypes")
	public void removeAll(Set s) {
		for(int i=0; i<s.size(); ++i){
			remove(s.get(i));
		}
	}

	@Override
	public void clear() {
		size = 0;
		head = new Node();
	}

	
	@Override
	public String toString() {
		Node p = head;
		StringBuilder sb = new StringBuilder();
		sb.append("LinkedListSet {");
		while(p.next != null){
			sb.append(p.next.volume);
			p = p.next;
			if(p.next != null){
				sb.append(", ");
			}
		}
		sb.append("}\n");
		
		return sb.toString();
	}	
	
	
	
	/*NESTED CLASS NODE*/
	private class Node{
		public Node next;
		public T volume;
		
		Node(){
			this.next = null;
			this.volume = null;
		}
		
		Node(T new_i, Node n){
			this.next = n;
			this.volume = new_i;
		}
		
		Node(T new_i){
			this.next = null;
			this.volume = new_i;
		}
	}
}
