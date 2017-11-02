

public class ReverseWords {
    
    
    
    public static void main(String[] args){
        String wordlist= "l  love you";
        System.out.println(reverseWords(wordlist));
        
    }
    
    public static String reverseWords(String words){
        if(words == null || words.length() == 1) return words;
        char [] array = words.toCharArray();
        int left = 0, right = 0;
        while(right < array.length){
            if(array[right] != ' '){
                right++;
            } else{
            reverse(array, left, right -1);
            left = ++right;
            }
            
        }
        reverse(array, left, right-1);
        reverse(array,0, array.length -1);
        
        return String.valueOf(array);
    }
    
    public static void reverse(char[] array, int left, int right){
        while(left < right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

}
