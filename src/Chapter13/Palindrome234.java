package Chapter13;

public class Palindrome234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 取到链表的中间
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next == null ? fast.next : fast.next.next;
        }

        // 从slow即中间开始反转链表
        ListNode before = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = before;
            before = slow;
            slow = next;
        }
        // 判断是是否是回文串
        while (fast.val == head.val) {
            fast = fast.next;
            head = head.next;

            if (fast == null) {
                return true;
            }
        }
        return false;
    }
}
