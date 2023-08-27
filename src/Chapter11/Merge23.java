package Chapter11;

import java.util.*;


public class Merge23 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 哑变量
        ListNode head = new ListNode();
        ListNode result = head;
        // 维护所有链表的头元素构成的堆heap
        PriorityQueue<ListNode> status_pq = new PriorityQueue(Comparator.comparingInt((ListNode a) -> a.val));

        for (ListNode list : lists) {
            if (list != null) {
                // 自动维护堆
                status_pq.add(list);
            }
        }

        while (!status_pq.isEmpty()) {
            ListNode current = status_pq.remove();

            head.next = current;
            head = head.next;
            if (current.next != null) {
                status_pq.add(current.next);
            }
        }
        return result.next;
    }
}
