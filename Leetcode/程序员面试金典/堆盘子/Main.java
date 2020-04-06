import java.util.ArrayDeque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        StackOfPlates sop = new StackOfPlates(2);
        sop.push(1);
        sop.push(2);
        sop.push(3);
        System.out.println(sop.popAt(0));
        System.out.println(sop.popAt(0));
        System.out.println(sop.popAt(0));
        System.out.println(sop.pop());
    }
}

class StackOfPlates {
    private LinkedList<ArrayDeque<Integer>> stacks;
    private int maxSize;

    public StackOfPlates(int cap) {
        stacks = new LinkedList<>();
        maxSize = cap;
    }
    
    public void push(int val) {
        if (!stacks.isEmpty() && stacks.getLast().size() < maxSize) {
            stacks.getLast().push(val);
        }
        else if (maxSize > 0) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.push(val);
            stacks.add(stack);
        }
    }
    
    public int pop() {
        int re = -1;
        if (!stacks.isEmpty()) {
            ArrayDeque<Integer> stack = stacks.getLast();
            re = stack.pop();
            if (stack.isEmpty()) {
                stacks.removeLast();
            }
        }
        return re;
    }
    
    public int popAt(int index) {
        int re = -1;
        if (stacks.size() > index) {
            ArrayDeque<Integer> stack = stacks.get(index);
            re = stack.pop();
            if (stack.isEmpty()) {
                stacks.remove(index);
            }
        }
        return re;
    }
}