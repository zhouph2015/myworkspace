package collection;

import java.util.HashSet;
import java.util.TreeSet;

public class TestSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testTreeSet();
		testHashSet();

	}
	
	
public static void testTreeSet(){
	TreeSet<String>  obj1= new TreeSet<String>();
    obj1.add("Alive");
    obj1.add("is");
    obj1.add("Awesome");
    System.out.println(obj1);
	
}


public static void testHashSet(){
    HashSet<String>  obj1= new HashSet<String>();
    obj1.add("Alive");
    obj1.add("is");
    obj1.add("Awesome");
    System.out.println(obj1);  
}

}
