package Chapter7;

import java.util.List;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] states = new boolean[s.length() + 1];
        states[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String target : wordDict) {
//                if (i >= target.length() && s.substring(i - target.length(), i).equals(target)) {
                if (i >= target.length() && s.startsWith(target, i - target.length())) {
                    states[i] = states[i] || states[i - target.length()];
                }
            }
        }
        return states[s.length()];
    }
}
