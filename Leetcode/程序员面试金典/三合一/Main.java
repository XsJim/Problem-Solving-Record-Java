public class Main {
    public static void main(String[] args) {
        TripleInOne t = new TripleInOne(1);
        t.push(0, 1);
        t.push(0, 2);
        System.out.println(t.peek(0));
        System.out.println(t.isEmpty(0));
        System.out.println(t.pop(0));
        System.out.println(t.pop(0));
        System.out.println(t.isEmpty(0));
    }
}

class TripleInOne {
    private int[] stack;
    private int[] size = new int[3];
    private int stackSize;

    public TripleInOne(int stackSize) {
        stack = new int[stackSize*3];
        this.stackSize = stackSize;
    }
    
    public void push(int stackNum, int value) {
        if (size[stackNum] != stackSize) {
            stack[size[stackNum]+stackSize*stackNum] = value;
            size[stackNum]++;
        }
    }
    
    public int pop(int stackNum) {
        if (size[stackNum] == 0) return -1;
        int re = stack[size[stackNum]+stackSize*stackNum-1];
        size[stackNum]--;
        return re;
    }

    public int peek(int stackNum) {
        if (size[stackNum] == 0) return -1;
        return stack[size[stackNum]+stackSize*stackNum-1];
    }
    
    public boolean isEmpty(int stackNum) {
        if (size[stackNum] == 0) return true;
        return false;
    }
}