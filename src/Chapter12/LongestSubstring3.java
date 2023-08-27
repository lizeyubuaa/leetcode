package Chapter12;

import java.util.HashSet;

public class LongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int l = 0;
        int r = 0;
        int currentLength = 0;
        int maxLength = 1;

        HashSet<Character> states = new HashSet<>();
        while (r < s.length()){
            // r移动
            while (r < s.length() && !states.contains(s.charAt(r))) {
                states.add(s.charAt(r));
                r++;
                currentLength++;
            }
            maxLength = Math.max(maxLength, currentLength);
            // l移动
            while (r < s.length() && states.contains(s.charAt(r))){
                states.remove(s.charAt(l));
                l++;
                currentLength--;
            }
        }
        return maxLength;
    }
    public int lengthOfLongestSubstring_dp(String s) {
        if (s.length() == 0) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 0; i < s.length(); i++) {
            currentLength = 1;
            HashSet<Character> states = new HashSet<>();
            states.add(s.charAt(i));

            for (int j = i + 1; j < s.length(); j++) {
                if (dp[i][j - 1] && !states.contains(s.charAt(j))) {
                    states.add(s.charAt(j));
                    currentLength += 1;
                    dp[i][j] = true;
                }
                else break;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
