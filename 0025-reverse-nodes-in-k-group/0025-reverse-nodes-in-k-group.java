class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
    
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pointerGroupPrev = dummy;
        
        while (true) {
            ListNode kthNode = getKthNode(pointerGroupPrev, k);
            if (kthNode == null) {
                break;
            }
            
            ListNode pointerGroupNext = kthNode.next;
            
            ListNode prev = kthNode.next; 
            ListNode curr = pointerGroupPrev.next;
            
            while (curr != pointerGroupNext) {
                ListNode tmpNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmpNext;
            }
            
            ListNode tmpNextGroupStart = pointerGroupPrev.next;
            pointerGroupPrev.next = kthNode;
            pointerGroupPrev = tmpNextGroupStart;
        }
        
        return dummy.next;
    }
    
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
