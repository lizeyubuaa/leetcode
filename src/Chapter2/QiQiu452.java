package Chapter2;

import java.util.Arrays;

public class QiQiu452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        else if (points.length == 1) return 1;
        Arrays.sort(points, (s, t) -> Integer.compare(s[1], t[1]));
        int count = 1;
        int edge = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[edge][1]) {
                count += 1;
                edge = i;
            }
        }
        return count;
    }
}