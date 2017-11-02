import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ValidatePythonCode2 {
    
    
    public static void main(String[] args) throws IOException{
        String line;
        File file = new File("./src/indeed/test.py");
        ArrayList<String> codelist = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        while((line = br.readLine())!= null){
            codelist.add(line);
        }
        ValidationRule(codelist);
    }
    
    public static void ValidationRule(List<String> list){
       Deque<IndentToken>  stack = new LinkedList<IndentToken>();

       IndentToken token = getIndentation(list.get(0));
       if(token.indent != 0){
           System.out.println("Indentation error at line 0" );
       } else {
           stack.push(token);
           for (int i = 1; i < list.size(); i++){
               IndentToken currentToken = getIndentation(list.get(i));
               if(stack.peek().isWillIndent()){
                   if(currentToken.getIndent() > stack.peek().getIndent()){
                       stack.push(currentToken);
                   } else {
                       System.out.println("Indentation error at line: " + i);
                   }
                   
               } else {
                   if(currentToken.getIndent() > stack.peek().getIndent()){
                       System.out.println("Indentation error" + i);
                   } else if (currentToken.getIndent() == stack.peek().getIndent()){
                      stack.pop();
                      stack.push(currentToken);
                   } else {
                       while(stack.peek().getIndent() > currentToken.getIndent()){
                           stack.pop();
                       }
                       
                       if (currentToken.getIndent() != stack.peek().getIndent()){
                           System.out.println("Indentation error" + i);
                       } else {
                           stack.pop();
                           stack.push(currentToken);
                       } 
                   }
               }
           }
       }
    }
    
    public static IndentToken getIndentation(String line) {
        if (line != null) {
            String newLine = line.replaceAll("^\\s+", "");
            int indent = line.length() - newLine.length();
            boolean willIndent;
            if (newLine.endsWith(":")) {
                willIndent = true;
            } else {
                willIndent = false;
            }
            IndentToken token = new IndentToken(indent, willIndent);
            return token;
        }
        return null;
    }
}

class IndentToken{
    
    public int getIndent() {
        return indent;
    }

    
    public void setIndent(int indent) {
        this.indent = indent;
    }

    
    public boolean isWillIndent() {
        return willIndent;
    }

    
    public void setWillIndent(boolean willIndent) {
        this.willIndent = willIndent;
    }

    int indent;
    boolean willIndent;
    
    public IndentToken(int indent, boolean willIndent){
        this.indent = indent;
        this.willIndent = willIndent;
        
    }
}



