package Chapter11;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b)->a[0] - b[0]);
        ArrayList<int[]> res = new ArrayList<>();
        int l = intervals[0][0];
        int r = intervals[0][1];
        res.add(new int[]{l, r});
        for (int[] interval : intervals) {
            if(interval[1] <= r) {
                continue;
            } else if (interval[0] <= r) {
                r = interval[1];
                res.remove(res.size() - 1);
                res.add(new int[]{l, r});
            }
            else{
                l = interval[0];
                r = interval[1];
                res.add(new int[]{l, r});
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}