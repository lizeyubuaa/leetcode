package Chapter13;

public class OddEven328 {
    // 索引为奇数偶数的分开
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        while (evenHead != null && evenHead.next != null) {
            ListNode current = evenHead.next;
            evenHead.next = current.next;
            evenHead = evenHead.next;

            current.next = oddHead.next;
            oddHead.next = current;
            oddHead = oddHead.next;
        }
        return head;
    }

    // 值为奇数偶数的分开
    public ListNode oddEvenList1(ListNode head) {
        ListNode res = head;
        ListNode otherHead = head;
        while (head != null && head.next != null) {
            ListNode current = head.next;
            if (head.next.val % 2 == res.val % 2) {
                head.next = head.next.next;
                current.next = otherHead.next;
                otherHead.next = current;
                otherHead = otherHead.next;
            }
            head = head.next;
        }
        return res;
    }
}
