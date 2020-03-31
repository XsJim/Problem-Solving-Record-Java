import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        SortedStack minStack = new SortedStack();
        minStack.push(5);
        minStack.push(6);
        System.out.println(minStack.peek());
        minStack.push(2);
        System.out.println(minStack.peek());
        minStack.push(6);
        System.out.println(minStack.peek());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.peek());
        minStack.pop();
        System.out.println(minStack.peek());
    }
}

class SortedStack {
    private ArrayDeque<Integer> stack;
    private static ArrayDeque<Integer> stack_buffer = new ArrayDeque<>();

    public SortedStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        while (!stack.isEmpty() && val > stack.getFirst()) {
            stack_buffer.push(stack.pop());
        }
        stack.push(val);
        while (!stack_buffer.isEmpty()) {
            stack.push(stack_buffer.pop());
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) stack.pop();
    }
    
    public int peek() {
        if (!stack.isEmpty()) return stack.getFirst();
        else return -1;
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}