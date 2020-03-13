import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        System.out.println(obj.max_value());
        obj.push_back(1);
        obj.push_back(2);
        System.out.println(obj.max_value());
        System.out.println(obj.pop_front());
        System.out.println(obj.max_value());
    }
}

class MaxQueue {
    private LinkedList<Integer> linkedList;

    public MaxQueue() {
        linkedList = new LinkedList<>();
    }
    
    public int max_value() {
        if (linkedList.size() == 0) return -1;
        int max = 0;
        for (int i : linkedList) {
            if (i > max) max = i;
        }
        return max;
    }
    
    public void push_back(int value) {
        linkedList.add(value);
    }
    
    public int pop_front() {
        if (linkedList.size() == 0) return -1;
        return linkedList.removeFirst();
    }
}