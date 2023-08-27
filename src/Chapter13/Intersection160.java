package Chapter13;

public class Intersection160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode current1 = headA;
        ListNode current2 = headB;
        // 不是快慢指针，只要一直走，一定走到交点或者同时到达链表尾部即null
        while (current1 != current2) {
            current1 = current1 == null ? headA : current1.next;
            current2 = current2 == null ? headB : current2.next;
        }
        return current1;
    }
}
