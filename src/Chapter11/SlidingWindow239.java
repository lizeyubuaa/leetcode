package Chapter11;

import java.util.*;

public class SlidingWindow239 {
    // 单调队列：既从队尾加入元素又从队尾删除元素；只从队头加入元素；从头到尾元素递减；存的是位置而不是值
    public int[] maxSlidingWindow_dq(int[] nums, int k) {
        // 特殊情况
        if (nums.length <= k) return new int[]{Arrays.stream(nums).max().getAsInt()};
        // 单调队列
        Deque<Integer> window = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        // 1.初始化
        for (int i = 0; i < k; i++) {
            // 先为入队建立基础条件
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.removeLast();
            }
            // 队列为空或者队尾元素大于当前元素，入队
            // 注意存的是下标
            window.addLast(i);
        }
        result[0] = nums[window.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.removeLast();
            }
            window.addLast(i);
            // 2.从队头出元素
            while (window.peekFirst() < i - k + 1) {
                window.removeFirst();
            }
            // 3.返回当前队头元素
            // i - k + 1是左窗口的下标
            result[i - k + 1] = nums[window.peekFirst()];
        }
        return result;
    }

    public int[] maxSlidingWindow_pq(int[] nums, int k) {
        // 大顶堆：int[]{num, index}
        // num降序, index升序
        PriorityQueue<Integer> window = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 != o2 ? nums[o2] - nums[o1] : o1 - o2;
            }
        });
        int[] result = new int[nums.length - k + 1];
        // 1.初始化
        for (int i = 0; i < k; i++) {
            window.add(i);
        }
        result[0] = nums[window.peek()];

        for (int i = k; i < nums.length; i++) {
            window.add(i);
            // 删除元素的时机为要获取最大值的时候
            while (!window.isEmpty() && window.peek() < i - k + 1) {
                window.poll();
            }
            result[i - k + 1] = nums[window.peek()];
        }
        return result;
    }
}

