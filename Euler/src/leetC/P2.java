package leetC;

/*
 * wrong answer:
 * null obj cannot contain its properties which leads to nullpointer error
 */

public class P2 {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// init:
    	ListNode head = new ListNode(0);
    	int rounding = 0;
    	ListNode result = new ListNode(0);
    	head.next = result;

//start
    	if(l1 == null && l2 == null){
    		return null;
    	}

//loop
    	while(l1 != null || l2 != null){
    		result.next = new ListNode(0);
    		result = result.next;
    		if(l1 != null){
    			result.val += l1.val;
    		}
    		if(l2 != null){
    			result.val += l2.val;
    		}
    		result.val += rounding;
    		if(result.val >= 10){
    			rounding = 1;
    			result.val -= 10;
    		}
    		else{
    			rounding = 0;
    		}
    		if(l1 != null){      
    			l1= l1.next;
    		}
    		if(l2 != null){
    			l2 = l2.next;   
    		}
    	}
// end check
    	if(rounding == 1){
    		result.next = new ListNode(1);
    	}

    	return head.next.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
