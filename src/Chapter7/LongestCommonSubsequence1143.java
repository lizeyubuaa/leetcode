package Chapter7;

import java.util.Arrays;
import java.util.Collections;

public class LongestCommonSubsequence1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] states = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) states[i][j] = states[i - 1][j - 1] + 1;
                else
                    states[i][j] = Collections.max(Arrays.asList(states[i][j - 1], states[i - 1][j], states[i - 1][j - 1]));
            }
        }
        return states[text1.length()][text2.length()];
    }
}
