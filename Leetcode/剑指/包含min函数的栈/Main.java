public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}

class Node {
    int val;
    Node next;
    public Node(int aval) {
        this.val = aval;
        this.next = null;
    }
}

class MinStack {
    private Node itop;
    private int imin;
    public MinStack() {
        this.itop = null;
        this.imin = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        Node tnew;
        if(x <= this.imin) {
            tnew = new Node(this.imin);
            tnew.next = this.itop;
            this.itop = tnew;
            this.imin = x;
        }
        tnew = new Node(x);
        tnew.next = this.itop;
        this.itop = tnew;
    }
    
    public void pop() {
        if (this.itop.val == this.imin) {
            this.itop = this.itop.next;
            this.imin = this.itop.val;
        }
        this.itop = this.itop.next;
    }
    
    public int top() {
        return this.itop.val;
    }
    
    public int min() {
        return this.imin;
    }
}