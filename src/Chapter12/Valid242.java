package Chapter12;

import java.util.Arrays;
import java.util.HashMap;

public class Valid242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> states = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            states.put(current, states.getOrDefault(current, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            if (states.getOrDefault(current, 0) == 0) return false;
            states.put(current, states.getOrDefault(current, 0) - 1);
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        Arrays.sort(s_arr);
        Arrays.sort(t_arr);
        for (int i = 0; i < s_arr.length; i++) {
            if (s_arr[i] != t_arr[i]) return false;
        }
        return true;
    }
}
