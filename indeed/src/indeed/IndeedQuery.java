package indeed;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class IndeedQuery {
    
    public static void main(String[] args) throws IOException{
        
        File file = new File("./src/indeed/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        HashMap<String, HashSet<Integer>>  recordmap = new HashMap<String, HashSet<Integer>>();
        String line;
        int lineCount = 1;
        while((line= br.readLine())!=null){
            String[] array = line.trim().split("\\s+");
            for(int i = 0; i < array.length; i++){
                if(recordmap.containsKey(array[i])){
                    recordmap.get(array[i]).add(lineCount);
                } else {
                    HashSet<Integer> set = new HashSet<Integer>();
                    set.add(lineCount);
                    recordmap.put(array[i], set);
                }
            }
        
            lineCount++;
        }
        
       Iterator<Map.Entry<String, HashSet<Integer>>> iterator = recordmap.entrySet().iterator();
       while(iterator.hasNext()){
           Map.Entry<String, HashSet<Integer>> entry = iterator.next();
           System.out.println(entry.getKey());
           System.out.println(entry.getValue());
       }
      /*  
        Scanner scan = new Scanner(System.in);
        
        while(true){
            System.out.print("Please Enter:");
            String a = scan.nextLine();
            System.out.println(a);
        } 
        */
        
    }
    
    

}
