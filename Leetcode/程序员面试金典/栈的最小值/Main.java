import java.util.ArrayDeque;

public class Main {
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

class MinStack {
    private ArrayDeque<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (min >= x) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.getFirst();
    }
    
    public int getMin() {
        return min;
    }
}