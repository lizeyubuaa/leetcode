package Chapter2;

import java.util.Arrays;

public class Intervals435 {
    public int eraseOverlapIntervals(int[][] intervals){
        if (intervals.length == 0) return 0;
        int count = 1;
        Arrays.sort(intervals, (s, t) -> s[1] - t[1]);
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
                count += 1;
            }
        }
        return intervals.length - count;
    }
}
