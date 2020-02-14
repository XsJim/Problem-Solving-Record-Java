import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("1:");
        CQueue queue = new CQueue();
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

        System.out.println("2:");
        CQueue queueB = new CQueue();
        System.out.println(queueB.deleteHead());
        queueB.appendTail(5);
        queueB.appendTail(2);
        System.out.println(queueB.deleteHead());
        System.out.println(queueB.deleteHead());
    }
}

class CQueue {
    private Stack<Integer> st_1;
    private Stack<Integer> st_2;

    public CQueue() {
        this.st_1 = new Stack<>();
        this.st_2 = new Stack<>();
    }
    
    public void appendTail(int value) {
        this.st_1.push(value);
    }
    
    public int deleteHead() {
        if (!st_2.empty()) return st_2.pop();
        if (!st_1.empty()) {
            while (!st_1.empty()) st_2.push(st_1.pop());
            return st_2.pop();
        } else return -1;
    }
}