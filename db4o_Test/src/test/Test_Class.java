package test;

import java.util.List;
import java.util.regex.Pattern;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

public class Test_Class {

	public static void main(final String[] args){
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "test.db");
		
		db.store(new Storage(1, "ahallo"));
		db.store(new Storage(2, "bhallo"));
		db.store(new Storage(3, "challo"));
		db.store(new Storage(4, "d"));
		
		List <Storage> list = db.query(new Predicate<Storage>(){
			public boolean match(Storage bw){
				System.out.println("found object, name: " + bw.getName());
				return Pattern.matches("*", bw.getName());
			}
		});
		
		for(Storage s : list){
			System.out.println(s.getName());
		}
	}
}
