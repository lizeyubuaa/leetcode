package Chapter12;

public class Palindromic647 {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extendSubstring(s, i, i);
            // 不要忘记偶数的情况
            count += extendSubstring(s, i, i + 1);
        }
        return count;
    }

    private int extendSubstring(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            count += 1;
            i--;
            j++;
        }
        return count;
    }

    public int countSubstrings_dp(String s) {
        boolean[][] states = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            states[i][i] = true;
        }
        int count = s.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i - 1) states[j][i] = true;
                    else states[j][i] = states[j + 1][i - 1];
                }
                if(states[j][i]) count += 1;
            }
        }
        return count;
    }
}