package Chapter5;

import java.util.*;
import java.util.stream.Collectors;

public class TopK347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] a = {1, 2};
        // TreeMap只能根据key排序
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        //将Map转换成List，实现对value排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(occurrences.entrySet());
        //法一
        // 通过比较器来实现排序
        list.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> num1, Map.Entry<Integer, Integer> num2) {
                //按照用户年龄降序
                return java.lang.Integer.compare(-num1.getValue(), -num2.getValue());
            }
        });
        // 法二
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        Collections.reverse(list);
        return list.stream().map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
    }
}