package Chapter7;

import java.util.Arrays;
import java.util.Collections;

public class WiggleSubsequence376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return 1;
        else if (nums.length == 2 && nums[0] != nums[1]) return 2;

        // pos[i] 表示以前i个元素中的某一个为结尾的最长的「上升摆动序列」的长度。
        // neg[i] 表示以前i个元素中的某一个为结尾的最长的「下降摆动序列」的长度。
        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];
        // 初始化，要与自己比较
        Arrays.fill(pos, 1);
        Arrays.fill(neg, 1);
        // 状态转移方程
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                pos[i] = Math.max(pos[i - 1], neg[i - 1] + 1);
                neg[i] = neg[i - 1];
            }
            else if (nums[i] < nums[i - 1]) {
                pos[i] = pos[i - 1];
                neg[i] = Math.max(pos[i - 1] + 1, neg[i - 1]);
            }
            else {
                pos[i] = pos[i - 1];
                neg[i] = neg[i - 1];
            }
        }
        return Math.max(pos[nums.length - 1], neg[nums.length - 1]);
    }
}