package Chapter7;

public class Decode91 {
    public int numDecodings(String s) {
        int[] state = new int[s.length() + 1];
        state[0] = 1;
        // 每次加一位数字进来
        for (int i = 1; i <= s.length(); i++) {
            // 取决于前i-1位的数字
            if (s.charAt(i - 1) != '0') state[i] += state[i - 1];
            // 取决于前i-2位的数字
            if (i >= 2 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0')) <= 26)
                state[i] += state[i - 2];
        }
        return state[s.length()];
    }
}
