package Chapter13;

public class Swap24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode temp = dummyHead;
        // 体现递归的思想，每次只处理虚拟头指针的后两个元素
        while (dummyHead.next != null && dummyHead.next.next != null) {
            ListNode first = dummyHead.next;
            ListNode second = dummyHead.next.next;
            dummyHead.next = second;
            first.next = second.next;
            second.next = first;

            dummyHead = dummyHead.next.next;
        }
        return temp.next;
    }

    public ListNode swapGroups(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (dummyHead.next != null && dummyHead.next.next != null && dummyHead.next.next.next != null) {
            ListNode first = dummyHead.next;
            ListNode third = dummyHead.next.next.next;
            dummyHead.next = third;
            if (dummyHead.next.next.next.next != null) {
                ListNode forth = dummyHead.next.next.next;
                forth.next = first;
            }
            else {
                third.next = first;
                break;
            }
            dummyHead = dummyHead.next.next.next.next;
        }
        return temp.next;
    }
}

