package indeed;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ValidatePhythonCode {
    
    public static void main(String[] args) throws IOException{
       
        String line;
        File file = new File("./src/indeed/test.py");
        ArrayList<String> codelist = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        while((line = br.readLine())!= null){
            codelist.add(line);
           
        }
        
        System.out.println(validatePythonCode(codelist));
        
    }
    
    
    public static boolean validatePythonCode(List<String> codelist) {

        Deque<String> stack = new LinkedList<String>();

        String firstLine = codelist.get(0);

        if (getIndentation(firstLine) != 0) {
            return false;
        } else {
            stack.push(firstLine);

            for (int i = 1; i < codelist.size(); i++) {
                    int curIndt = getIndentation(codelist.get(i));
                    int preIndt = getIndentation(stack.peek());
                    
                    System.out.println(stack.peek());
                    
                    if(!stack.isEmpty() && stack.peek().trim().endsWith(":")){
                         if (curIndt > preIndt){
                             stack.push(codelist.get(i));
                         } else {
                             System.out.println("Indentation error at lines: " +i);
                             return false;
                         } 

                } else {
                       if(curIndt > preIndt){
                           System.out.println("Indentation error at lines: " +i);
                           return false;
                       } else if (curIndt == preIndt){
                           stack.pop();
                           stack.push(codelist.get(i));
                       } else {
                           
                           while(getIndentation(stack.peek()) < curIndt){
                               stack.pop();
                           }
                           
                           if(getIndentation(stack.peek()) !=  curIndt){
                               System.out.println("Indentation error at lines: " +i);
                               return false;
                           } else {
                               
                               stack.pop();
                           }
                           
                       }
                }
            }
        }
        return true;
    }
    
    
    public static int getIndentation(String line){
        if(line != null){
        String newLine =   line.replaceAll("^\\s+", "");
        return line.length() - newLine.length();
        } else {
            return 0;
        }
    }

}
