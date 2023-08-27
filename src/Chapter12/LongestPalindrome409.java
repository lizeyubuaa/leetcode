package Chapter12;

import java.util.HashMap;

public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        int count = 0;
        boolean even = false;
        HashMap<Character, Integer> states = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            states.put(ch, states.getOrDefault(ch, 0) + 1);
        }
        for (Integer value : states.values()) {
            if(value % 2 == 0) count += value;
            else if(!even) {
                even = true;
                count += value;
            }
            else count += value - 1;
        }
        return count;
    }
}
