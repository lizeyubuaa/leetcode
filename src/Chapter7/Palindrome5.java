package Chapter7;

public class Palindrome5 {

    public String longestPalindrome0(String s) {
        if (s.length() <= 1) return s;

        boolean[][] state = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            state[i][i] = true;
        }

        int max_len = 1;
        int len;
        String res = s.substring(0, 1);

        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j + 1) state[j][i] = true;
                    else state[j][i] = state[j + 1][i - 1];

                    if (state[j][i] && max_len < (len = i - j + 1)) {
                        max_len = len;
                        res = s.substring(j, i + 1);
                    }
                }
            }
        }
        return res;
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int len = 0;
        int l = 0;
        int r = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome(s.substring(j, i + 1))) {
                    if (len < (i - j + 1)) {
                        len = i - j + 1;
                        l = j;
                        r = i;
                    }
                }
            }
        }
        return len > 0 ? s.substring(l, r + 1) : s.substring(0, 1);
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return true;
        if (s.charAt(0) == s.charAt(n - 1)) return isPalindrome(s.substring(1, n - 1));
        else return false;
    }
}
