import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CustomStack cStack = new CustomStack(3);
        cStack.push(1);
        cStack.push(2);
        System.out.println(cStack.pop());
        cStack.push(2);
        cStack.push(3);
        cStack.push(4);
        cStack.increment(5, 100);
        cStack.increment(2, 100);
        System.out.println(cStack.pop());
        System.out.println(cStack.pop());
        System.out.println(cStack.pop());
        System.out.println(cStack.pop());
    }
}

class CustomStack {
    private int sp;
    private int maxP;
    private int[] stack;
    private int[] add;
    public CustomStack(int maxSize) {
        sp = -1;
        stack = new int[maxSize];
        add = new int[maxSize];
        this.maxP = maxSize - 1;
    }
    
    public void push(int x) {
        if (sp < maxP) stack[++sp] = x;
    }
    
    public int pop() {
        if (sp > -1) {
            if (sp > 0) add[sp-1] += add[sp];
            int re = stack[sp] + add[sp];
            add[sp--] = 0;
            return re;
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        if (sp > -1) add[Math.min(sp, k-1)] += val;
    }
}