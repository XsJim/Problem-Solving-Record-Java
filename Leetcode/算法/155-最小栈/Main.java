import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}

class MinStack {
    // 创建两个栈，一个是常规栈，另一个存放当前最小值
    // 当有元素入栈时，首先将其压入常规栈，再判断它是否小于当前最小值
    // 如果小于最小值，将最小值更改
    // 再将最小值压入辅助栈
    // 弹出时，两个栈都弹出元素，再将最小值改为辅助栈的栈顶，它依然是当前最小值
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int min;
    public MinStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        stack1.push(x);
        if (x < min) min = x;
        stack2.push(min);
    }
    
    public void pop() {
        stack1.pop();
        stack2.pop();
        if (stack2.empty()) min = Integer.MAX_VALUE;
        else min = stack2.peek();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return min;
    }
}