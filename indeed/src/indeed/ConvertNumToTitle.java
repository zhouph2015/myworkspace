package indeed;


public class ConvertNumToTitle {
    
    public static void main(String[] args){
        
        System.out.println(convertToTitle(28));
        
        
        System.out.println(convertToTitle1(28));
        
        System.out.println(convertToNum("ABC"));
    }
    
    
    
    
    public static String convertToTitle(int n){
        
        if( n <= 0){
            throw new IllegalArgumentException("Input is not valid!");
        }
        
        StringBuilder sb = new StringBuilder();
        
        while( n > 0){
            n--;
            
            char ch = (char)(n%26 +'A');
            n =n/26;
            sb.append(ch);
            
        }
        sb.reverse();
        return sb.toString();
        
    }
    
    
    public static String convertToTitle1(int n){
        if(n <=0 ){
            throw new IllegalArgumentException("Invalid input");
        }
        String s="";
        
        while(n >0){
            n--;
            s = String.valueOf((char)(n%26 +'A')) + s;
            n= n/26;
        }
        return s;
    }
    
    
    public static int convertToNum(String title){
        int result = 0;
        for(int i = 0; i < title.length(); i++){
            
            result = result *26 + (title.charAt(i)-'A') +1;
            
        }
        
        return result;
        
    }

}
