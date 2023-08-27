package Chapter16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AllOne432 {
    // 双向链表
    private final DLinkedList head = new DLinkedList();
    private final DLinkedList tail = new DLinkedList();
    // 哈希表，存储字符串所在的位置
    private final Map<String, DLinkedList> cache;

    static class DLinkedList {
        // 存储单词的出现次数
        int count;
        // 存储相同出现次数的单词集
        HashSet<String> data;
        DLinkedList pre;
        DLinkedList next;

        public DLinkedList() {
            // 调用另一个构造器
            this(0, "");
        }

        public DLinkedList(int count, String str) {
            this.count = count;
            this.data = new HashSet<>();
            this.data.add(str);
        }

        // 封装了统一的函数
        // 删除当前的节点
        public void remove() {
            this.pre.next = this.next;
            this.next.pre = this.pre;
        }

        // 在当前的节点后添加新节点
        public void insert(DLinkedList new_node) {
            new_node.pre = this;
            new_node.next = this.next;
            new_node.pre.next = new_node;
            new_node.next.pre = new_node;
        }
    }

    public AllOne432() {
        cache = new HashMap<>();

        head.next = tail;
        tail.pre = head;
    }

    public void inc(String key) {
        if (cache.containsKey(key)) {
            DLinkedList current = cache.get(key);
            // 插入，先插后删
            if (current.next == null || current.next.count - current.count != 1) {
                DLinkedList new_node = new DLinkedList(current.count + 1, key);
                current.insert(new_node);
            }
            else {
                current.next.data.add(key);
            }
            // 不要忘记修改cache
            cache.put(key, current.next);
            // 删除
            current.data.remove(key);
            if (current.data.isEmpty()) current.remove();
        }
        else {
            if (head.next == null || head.next.count != 1) {
                DLinkedList new_node = new DLinkedList(1, key);
                head.insert(new_node);
            }
            else {
                head.next.data.add(key);
            }
            cache.put(key, head.next);
        }
    }


    public void dec(String key) {
        // 测试用例保证cache中存在key
        if (cache.containsKey(key)) {
            DLinkedList current = cache.get(key);
            // 插入，先插后删
            // current.pre一定存在；current.next不一定存在
            if (current.count - current.pre.count != 1) {
                DLinkedList new_node = new DLinkedList(current.count - 1, key);
                current.pre.insert(new_node);
            }
            else {
                current.pre.data.add(key);
            }
            // 不要忘记修改cache
            cache.put(key, current.pre);
            // 删除
            current.data.remove(key);
            if (current.data.isEmpty()) current.remove();
        }
    }

    public String getMaxKey() {
        if (tail.pre != null) return tail.pre.data.iterator().next();
        else return "";
    }

    public String getMinKey() {
        if (head.next != null) return head.next.data.iterator().next();
        else return "";
    }
}
