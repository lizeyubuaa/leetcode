package Chapter9;

import java.util.Random;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedListRandomNode382 {
    // 水塘抽样法
    private final ListNode head;
    private final Random random = new Random();

    public LinkedListRandomNode382(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        // 注意变量要设置为局部变量，不能设置为成员变量
        int res = 0;
        int no = 0;
        ListNode head = this.head;

        while (head != null) {
            no += 1;
            res = random.nextInt(no) == 0 ? head.val : res;
            head = head.next;
        }
        return res;
    }
}