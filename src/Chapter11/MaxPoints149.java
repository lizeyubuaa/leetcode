package Chapter11;

import java.util.HashMap;
import java.util.Map;

public class MaxPoints149 {
    public int maxPoints(int[][] points) {
        Map<Double, Integer> state = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            // 完全相同
            int same = 1;
            // 斜率不存在
            int same_y = 1;
            // 竖直的线
            int same_x = 1;

            for (int j = i + 1; j < points.length; j++) {
                if (points[i][1] == points[j][1]) {
                    same_y += 1;
                    if (points[i][0] == points[j][0]) {
                        same += 1;
                    }
                }
                else if (points[i][0] == points[j][0]) {
                    same_x += 1;
                }
                else {
                    double k = (double) (points[i][1] - points[j][1]) / (double) (points[i][0] - points[j][0]);
                    state.put(k, state.getOrDefault(k, 0) + 1);
                }
            }
            ans = Math.max(ans, same_y);
            ans = Math.max(ans, same_x);
            for (Integer value : state.values()) {
                ans = Math.max(ans, same + value);
            }
            // 不要忘记
            state.clear();
        }
        return ans;
    }
}
