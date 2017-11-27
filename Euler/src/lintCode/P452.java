package lintCode;

public class P452 {
	
	public ListNode removeElements(ListNode head, int val) {
		ListNode header = new ListNode(0);
		header.next = head;
		ListNode iter = header;
		
		while(iter.next != null){
			if(iter.next.val != val){
				iter = iter.next;
			} else{
				iter.next = iter.next.next;
			}
		}
		
		return header.next;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}