package aufgabe3;

import aufgabe2.AbstractSet;
import aufgabe2.Set;

public class LinkedListSet extends AbstractSet{
	
	private Node head;
	
	
	/*CONTRUCTOR*/
	public LinkedListSet(){
		clear();		
	}

	@Override
	public void add(int x) {
		Node p = head;
		
		if(contains(x)){
			return;
		}
		
		if(isEmpty()){
			p.next = new Node(x);
			incrSize();
			return;
		}
		
		while(p.next != null && x > p.next.volume){
			p = p.next;
		}
		p.next = new Node(x, p.next);
		incrSize();
		
	}

	@Override
	public void remove(int x) {
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
	public boolean contains(int x) {
		Node p;
		for(p = head; p.next != null; p = p.next){
			if(p.next.volume == x){
				return true;
			}
		}
		return false;
	}

	@Override
	public int get(int i) {
		Node p = head.next;
		for(int index=0;index<i;++index){
			p = p.next;
		}
		return p.volume;
	}

	@Override
	public boolean containsAll(Set s) {		
		for(int i=0;i<s.size();++i){
			if(!contains(s.get(i))){
				return false;
			}
		}
		return true;
	}

	
	@Override
	public void addAll(Set s) {
		for(int i=0;i<s.size();++i){
			add(s.get(i));
		}
	}
	

	@Override
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
		public int volume;
		
		Node(){
			this.next = null;
			this.volume = 0;
		}
		
		Node(int new_i, Node n){
			this.next = n;
			this.volume = new_i;
		}
		
		Node(int new_i){
			this.next = null;
			this.volume = new_i;
		}
	}
}
