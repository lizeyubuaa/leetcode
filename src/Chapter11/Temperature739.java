package Chapter11;

import java.util.ArrayDeque;

public class Temperature739 {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> states = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            // 出栈
            while(!states.isEmpty() && temperatures[states.peek()] < temperatures[i]){
                res[states.peek()] = i - states.peek();
                states.pop();
            }
            // 入栈
            states.push(i);
        }
        return res;
    }
}
