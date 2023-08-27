package Chapter12;


import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator227 {
    public int calculate(String s) {
        int n = s.length();
        // 存储当前的number
        int num = 0;
        // 存储结果
        int res = 0;
        // 根据前一个运算符而不是当前运算符来决定入栈的情况
        char preSign = '+';
        // 运算栈
        Deque<Integer> stack = new ArrayDeque<>();
        // 一个大循环里做3件事情
        for (int i = 0; i < n; ) {
            // 读完一个数字
            if (Character.isDigit(s.charAt(i))) {
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + s.charAt(i) - '0';
                    i++;
                }
            }
            // 去除空格
            while (i < n && s.charAt(i) == ' ') i++;
            // 根据前一个运算符或者是当前最后一个数字
            if (i == n || !Character.isDigit(s.charAt(i))) {
                switch (preSign) {
                    case '+' -> stack.addLast(num);
                    case '-' -> stack.addLast(-num);
                    case '*' -> stack.addLast(stack.removeLast() * num);
                    case '/' -> stack.addLast(stack.removeLast() / num);
                }
                // 当前数字归零
                num = 0;
                // 把当前运算符置为下一次运算的运算符
                if (i < n) preSign = s.charAt(i);
                i++;
            }
        }
        // 出栈、加和
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}