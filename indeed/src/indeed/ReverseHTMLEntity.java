package indeed;

import java.util.ArrayList;
import java.util.List;

public class ReverseHTMLEntity {
    
    public static void main( String[] args){
        
        //String s = "1234&euro;";
         //String s = ";";
        //System.out.println(s.substring(0,1));
        
        //reverseHTML("1234&&euro;");
        //reverseHTML("&&");
        System.out.println(reverseHTML("1231245"));
        
        //System.out.println(reverseHTML("1234&&euro;"));
        
        System.out.println(reverseString("12345678acx"));
    }
    

    public static String reverseHTML(String s) {

        if (s == null || s.length() == 1) {
            return s;
        }

        List<Token> tokens= new ArrayList<>();
        int start = 0;
        int end = 0;
        boolean HtmlEntityStart = false;
        boolean HtmlEntityEnd= false;

        while (end < s.length()) {
            char c = s.charAt(end);

            if (c == '&' ) {

                Token token = new Token();
                token.value = s.substring(start, end );
                if (HtmlEntityStart && HtmlEntityEnd) {
                    token.iSHtmlEntity = true;

                }
                tokens.add(token);
                start = end;
                HtmlEntityStart = true;
                HtmlEntityEnd = false;
                end++;
            } else if (c == ';') {
                HtmlEntityEnd = true;

                if (HtmlEntityStart && HtmlEntityEnd) {
                    Token token = new Token();
                    token.value = s.substring(start, end +1);
                    if (HtmlEntityStart && HtmlEntityEnd) {
                        token.iSHtmlEntity = true;
                    }
                    tokens.add(token);
                    start = end +1;
                }
                
                HtmlEntityStart = false;
                end++;
            } else{
                end++;
            }
            
            
        }
        if(start < end){
            Token token = new Token();
            token.value = s.substring(start, end);
            tokens.add(token);
        }
       String result ="";
       for (Token token: tokens){
           if(token.iSHtmlEntity){
               result = token.value + result; 
           } else{
               result = reverseString(token.value) + result; 
           }

       }
        
        return result;

    }
    
    public static String reverseString(String s){
        
        if(s.length() == 1) return s;
        
        char[] temparray = s.toCharArray();
        int left, right=0;
        right = temparray.length-1;
 
        for (left=0; left < right ; left++ ,right--)
        {
            // Swap values of left and right
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right]=temp;
        }
        
        return String.valueOf(temparray);
    }


  

}




