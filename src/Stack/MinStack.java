package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<int[]> stk = new ArrayDeque<>();

    public MinStack() {
        stk.push(new int[]{0, Integer.MAX_VALUE});
    }

    public void push(int val) {
        stk.push(new int[]{val, Math.min(getMin(), val)});
    }

    public void pop() {
        stk.pop();
    }

    public int top() {
        return stk.peek()[0];
    }

    public int getMin() {
        return stk.peek()[1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
