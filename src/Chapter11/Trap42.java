package Chapter11;

import java.util.ArrayDeque;


public class Trap42 {
    // 单调栈，基模型是大小大，要求栈中至少有两个元素
    public int trap(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < height.length; i++) {
            // 入栈前需要满足条件，要求比栈顶元素大
            while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                int top = stack.removeLast();
                // 栈中只有一个元素，无需计算
                if (stack.isEmpty()) break;
                // 距离×高度
                cnt += (Math.min(height[i], height[stack.peekLast()]) - height[top]) * (i - stack.peekLast() - 1);
            }
            stack.addLast(i);
        }
        return cnt;
    }
}