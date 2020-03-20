import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
    }
}

class MyQueue {
    private ArrayDeque<Integer> adIn;
    private ArrayDeque<Integer> adOut;

    /** Initialize your data structure here. */
    public MyQueue() {
        adIn = new ArrayDeque<>();
        adOut = new ArrayDeque<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        adIn.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        load();
        return adOut.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        load();
        return adOut.getFirst();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return adIn.isEmpty() && adOut.isEmpty();
    }

    private void load() {
        if (adOut.isEmpty()) {
            while (!adIn.isEmpty()) {
                adOut.push(adIn.pop());
            }
        }
    }
}