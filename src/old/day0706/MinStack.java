package old.day0706;

import java.util.Stack;

/**
 * 最小栈的实现
 */
public class MinStack {
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int element) {
        mainStack.push(element);
        if (minStack.empty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    public Integer pop() {
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin() throws Exception {
        if (mainStack.empty()) {
            throw new Exception("stack is empty!");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
