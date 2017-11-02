package amazon;

public class FindIntersectionOfTwoList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    //boundary check
	    if(headA == null || headB == null) return null;
	    
	    ListNode a = headA;
	    ListNode b = headB;
	    
	    //if a & b have different len, then we will stop the loop after second iteration
	    while( a != b){
	    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next;    
	    }
	    
	    return a;
	}
	
	
	
	public static ListNode getIntersectionNode_one(ListNode headA, ListNode headB){
		
		int lenA = length(headA);
		int lenB = length(headB);
		
		while(lenA> lenB){
			headA=headA.next;
			lenA--;
		}
		
		while(lenB>lenA){
			headB=headB.next;
			lenB--;
		}
		
		while(headA != headB){
			headA = headA.next;
			headB=headB.next;
			
		}
		
		return headA;
		
		
	}
	
	private static int length(ListNode head){
		
		int length = 0;
		ListNode cursor = head;
		while( cursor != null){
			cursor = cursor.next;
			length++;
		}
		return length;
	}

}
