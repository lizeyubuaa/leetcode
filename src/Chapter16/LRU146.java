package Chapter16;

import java.util.HashMap;
import java.util.Map;


class LRU146 {
    static class DLinkedList {
        int _key;
        int _val;
        DLinkedList pre;
        DLinkedList next;

        public DLinkedList() {
        }

        public DLinkedList(int key, int val) {
            _key = key;
            _val = val;
        }
    }

    int size;
    int capacity;
    DLinkedList head;
    DLinkedList tail;
    // 双向链表+哈希表
    private final Map<Integer, DLinkedList> cache = new HashMap<>();

    // 缓存表
    public LRU146(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // 不存在
        if (cache.get(key) == null) {
            return -1;
        }
        else {
            moveHead(cache.get(key));
            return cache.get(key)._val;
        }

    }

    public void put(int key, int value) {
        DLinkedList node;
        if (cache.get(key) == null) {
            node = new DLinkedList(key, value);
            // 添加至缓存表
            cache.put(key, node);
            // 修改前后向指针
            if (size >= capacity) {
                DLinkedList tail = removeTail();
                cache.remove(tail._key);
                size--;
            }
            addHead(node);
            size++;

        }
        else {
            node = cache.get(key);
            node._val = value;
            moveHead(node);
        }
    }

    public DLinkedList remove(DLinkedList node) {
        // 两个指针
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }

    public void addHead(DLinkedList node) {
        // 四个指针
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void moveHead(DLinkedList node) {
        remove(node);
        addHead(node);
    }

    public DLinkedList removeTail() {
        return remove(tail.pre);
    }
}
