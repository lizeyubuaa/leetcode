package Chapter13;

public class Reverse206 {
    public ListNode reverseList(ListNode head) {
        ListNode before = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            // 提前存一下下一个节点
            next = current.next;
            // 改当前节点
            current.next = before;
            // 准备下一个节点
            before = current;
            current = next;
        }
        return before;
    }

    public ListNode reverseListRec(ListNode head) {
        if(head == null) return null;
        return rec(null, head);
    }

    public ListNode rec(ListNode before, ListNode current){
        ListNode next = current.next;
        current.next = before;
        before = current;
        if(next == null) return current;
        else{
            return rec(before, next);
        }
    }
}
