package indeed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class testCode {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }
        System.out.printf("BEFORE ITERATOR\n");
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("I:%d\n", a.get(i));
        }
        System.out.printf("AFTER ITERATOR\n");
        Iterator i = a.iterator();
        while (i.hasNext()) {
            System.out.printf("I:%d\n", i.next());
        }
        
        
        Random  rn = new Random();
            rn.nextInt();
    }
    

        
    }
}
