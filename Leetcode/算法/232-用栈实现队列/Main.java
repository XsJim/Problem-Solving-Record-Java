import java.util.Stack;

public class Main  {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        check();
        return stack2.pop();
        
    }
    
    public int peek() {
        check();
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

    private void check() {
        if (!stack2.empty()) return;
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }
}