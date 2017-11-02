package amazon;

public class RevisedLinkedList {

	public static void main (String[] args) {
		ListNode test = createList(7);
		showList(test);
		
		ListNode temp = reverse_one(test);
		showList(temp);
		System.out.println("");
		showList(reverse_two(temp));

	}
	
	
	public static ListNode reverse_one(ListNode head){
		if(head == null) return null;
		ListNode newHead = null;
		ListNode next = null;
			
		while(head != null){
		
			next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
                      
		}
		
		return newHead;
		
	}
	
	
	public static ListNode reverse_two(ListNode head){
		return reverse_two(head, null);
	}
	
	public static ListNode reverse_two(ListNode head, ListNode newHead){
		if ( head == null) return newHead;
		
		ListNode next = head.next;
		head.next = newHead;
		return reverse_two(next, head);
	}
	
	
	public static void showList (ListNode head){
		ListNode cursor = head;
		System.out.print("List: ");
		while(cursor != null){
			System.out.print(cursor.val + ", ");
			cursor = cursor.next;
		}
		
	}
	
	public  static ListNode createList(int size){
		ListNode head = new ListNode(1);
		ListNode cursor = head;
		for(int i = 2; i < size+2; i++){
			cursor.next= new ListNode(i);
			cursor= cursor.next;
		}
		return head;
	}
	
	
	
	
}



