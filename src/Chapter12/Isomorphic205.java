package Chapter12;

import java.util.HashMap;
import java.util.Objects;

public class Isomorphic205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> s_first_index = new HashMap<>();
        HashMap<Character, Integer> t_first_index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s_ch = s.charAt(i);
            char t_ch = t.charAt(i);
            if (s_first_index.getOrDefault(s_ch, 0) == 0 && t_first_index.getOrDefault(t_ch, 0) == 0) {
                // 注意和0错一下位
                s_first_index.put(s_ch, i + 1);
                t_first_index.put(t_ch, i + 1);
            }
            else if (s_first_index.getOrDefault(s_ch, 0).intValue() == t_first_index.getOrDefault(t_ch, 0).intValue()) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
