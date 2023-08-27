package Chapter16;

import java.util.*;

public class InsertDelete380 {
    Map<Integer, Integer> cache;
    List<Integer> data;

    public InsertDelete380() {
        // 哈希表无法做到O(1)随机返回一个元素
        cache = new HashMap<>();
        // 列表无法做到O(1)判断一个元素是否在列表中(影响到元素的删除和插入)
        data = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (cache.containsKey(val)) return false;
        else {
            cache.put(val, data.size());
            data.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!cache.containsKey(val)) return false;
        else {
            // 把数组最后一个元素放到val元素的位置
            cache.put(data.get(data.size() - 1), cache.get(val));
            data.set(cache.get(val), data.get(data.size() - 1));
            cache.remove(val);
            data.remove(data.size() - 1);

            return true;
        }
    }

    public int getRandom() {
        return data.get(new Random().nextInt(data.size()));
    }
}