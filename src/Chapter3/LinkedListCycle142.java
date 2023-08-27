package Chapter3;

/**
 * Definition for singly-linked list.
 * class Chapter3.ListNode {
 * int val;
 * Chapter3.ListNode next;
 * Chapter3.ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */


public class LinkedListCycle142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head == null) return null;
        do {
            if(fast.next == null) return null;
            else fast = fast.next.next;
            slow = slow.next;
        }
        while (fast != slow && fast != null);

        if (fast != null) {
            fast = head;
        }
        else return null;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}