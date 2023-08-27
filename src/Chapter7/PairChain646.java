package Chapter7;

import java.util.Arrays;
import java.util.Comparator;

public class PairChain646 {
    public int findLongestChain0(int[][] pairs) {
        int[] dp = new int[pairs.length + 1];
        // 初始化
        Arrays.fill(dp, 1);
        // 按照第二个元素排序
        Arrays.sort(pairs, Comparator.comparingInt((P) -> P[1]));

        for (int i = 1; i <= pairs.length; i++) {
            // 需要多次更新，往往不是取决于与目标比较第一个成功的对象
            for (int j = 1; j < i; j++) {
                if (pairs[i - 1][0] > pairs[j - 1][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
    
    public int eraseOverlappairsGreedy(int[][] pairs){
        if (pairs.length == 0) return 0;
        int count = 1;
        Arrays.sort(pairs, (s, t) -> s[1] - t[1]);
        int right = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] >= right) {
                right = pairs[i][1];
                count += 1;
            }
        }
        return pairs.length - count;
    }
}
