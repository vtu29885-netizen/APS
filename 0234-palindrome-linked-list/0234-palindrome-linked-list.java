class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHalfHead = reverseList(slow);
        
        ListNode firstHalfPointer = head;
        ListNode secondHalfPointer = secondHalfHead;
        boolean isPalin = true;
        
        while (secondHalfPointer != null) {
            if (firstHalfPointer.val != secondHalfPointer.val) {
                isPalin = false;
                break;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }
        
        reverseList(secondHalfHead);
        
        return isPalin;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
