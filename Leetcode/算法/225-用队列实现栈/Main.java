import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        stack.push(4);
        stack.push(5);
        while (!stack.empty()) System.out.println(stack.pop());
    }
}

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int size;
    private int tTop;
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
        tTop = -1;
        size = 0;
    }
    
    public void push(int x) {
        tTop = x;
        queue1.add(x);
        size++;
    }
    
    public int pop() {
        for (int i = size; i > 1; i--) {
            tTop = queue1.remove();
            queue2.add(tTop);
        }
        size--;
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return queue2.remove();
    }
    
    public int top() {
        return tTop;
    }
    
    public boolean empty() {
        return size == 0;
    }
}