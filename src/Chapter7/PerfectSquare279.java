package Chapter7;

import java.util.Arrays;

public class PerfectSquare279 {
    public int numSquares(int n) {
        int[] state = new int[n + 1];
        Arrays.fill(state, 99999);
        state[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                state[i] = Math.min(state[i], state[i - j * j] + 1);
            }
        }
        return state[n];
    }
}