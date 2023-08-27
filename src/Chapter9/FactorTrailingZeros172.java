package Chapter9;

public class FactorTrailingZeros172 {
    public int trailingZeroes(int n) {
        // 1.转化为 2 * 5
        // 2.转化为找[1, n]可以找到多少个5
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num % 5 == 0) {
                cnt += 1;
                num /= 5;
            }
        }
        return cnt;
    }

    public int trailingZeroes1(int n) {
        // 1.转化为 2 * 5
        // 2.转化为找[1, n]可以找到多少个5
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
