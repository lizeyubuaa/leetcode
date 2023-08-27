package Chapter13;

public class Merge21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟的头指针非常好用
        ListNode head = new ListNode(-1);
        ListNode result = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                head.next = list2;
                list2 = list2.next;
            }
            else {
                head.next = list1;
                list1 = list1.next;
            }
            head = head.next;
        }
        head.next = list1 == null ? list2 : list1;

        return result.next;
    }
}
