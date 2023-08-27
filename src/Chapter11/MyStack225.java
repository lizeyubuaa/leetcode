package Chapter11;

import java.util.ArrayDeque;

public class MyStack225 {

    private ArrayDeque<Integer> q1;
    // 入栈时的临时存储
    private ArrayDeque<Integer> q2;

    public MyStack225() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        q2.addLast(x);
        while (!q1.isEmpty()) q2.addLast(q1.removeFirst());
        ArrayDeque<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.removeFirst();
    }

    public int top() {
        return q1.getFirst();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
