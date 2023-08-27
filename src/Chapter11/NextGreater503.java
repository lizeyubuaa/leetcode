package Chapter11;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreater503 {
    public int[] nextGreaterElements(int[] nums) {
        // 单调栈，保存的是下标
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // 保存结果
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int n = 2 * nums.length - 1;
        for (int i = 0; i < n; i++) {
            // 入栈需要满足前提条件
            while (!stack.isEmpty() && nums[stack.getLast()] < nums[i % nums.length]) res[stack.removeLast()] = i % nums.length;
            stack.addLast(i % nums.length);
        }
        return res;
    }
}
