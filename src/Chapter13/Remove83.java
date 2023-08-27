package Chapter13;

public class Remove83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        while (head != null) {
            while (head.next != null && head.val == head.next.val) head.next = head.next.next;
            head = head.next;
        }
        return res;
    }
}