package amazon;

import java.util.Stack;

public class ValidParenth {
	
	public static void main(String[] args){
		String test = "({[()]}[]{()})";
		System.out.println(isValid_one(test));
		String test2 = "({[()]}){";
		System.out.println(isValid_one(test2));
		

		System.out.println(isValid_two(test));
	
		System.out.println(isValid_two(test2));
		
		
	}
	
	
	public static boolean isValid_one(String input){
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < input.length(); i++){
			
			switch( input.charAt(i)){
			case'(':
				stack.push('(');
			    break;
			case'[':
				stack.push('[');
				break;
			case '{':
				stack.push('{');
				break;
			case ']':
				if(stack.size() ==0 || stack.pop() != '[')
					return false;
				break;
			case '}':
				if(stack.size() ==0 || stack.pop() != '{')
					return false;
				break;
			case ')':
				if(stack.size() ==0 || stack.pop() != '(')
					return false;
				break;
				
				
			}
		}
		
		return stack.isEmpty();
	}
	
	
	public static boolean isValid_two(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
	

}
