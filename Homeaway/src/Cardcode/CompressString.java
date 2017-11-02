package Cardcode;


public class CompressString {
    
    public static void main(String[] args){
        String input= "aaaaaaabbbbcccddddddddd";
        
        System.out.println(compress(input));
    }
    public static String compress(String string){
        if(string == null) return null;
        if(string.length() == 0) return "";
        if(string.length() == 1) return string+"1";
        char[] array = string.toCharArray();
        char symbol = array[0];
        String results="";
        int count = 1;
        int i = 0;
        while( i < array.length ){
            if(array[i]!= symbol){
                results+=Character.toString(symbol) +count;
                symbol = array[i];
                count = 1;
            }else{
                count++;
            }
            i++;
            
        }
        results+=Character.toString(symbol) +count;
        
        return results;
        
    }
    
    public static String  decompress(String string){
        if(string == null) return null;
        char[] array = string.toCharArray();
        StringBuilder 
        
    }
}
