package Chapter2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Partition763 {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> cache = new HashMap<>();
        // 遍历得到每个字符的最后一次出现位置
        for (int i = 0; i < s.length(); i++) {
            cache.put(s.charAt(i), i);
        }
        // 贪心遍历
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, cache.get(s.charAt(i)));
            if(i == end){
                result.add(end - start + 1);
                end = end + 1;
                start = end;
            }
        }
        return result;
    }
}
