import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(-1);
        System.out.println(obj.findMedian());
        obj.addNum(-2);
        System.out.println(obj.findMedian());
        obj.addNum(-3);
        System.out.println(obj.findMedian());
        obj.addNum(-4);
        System.out.println(obj.findMedian());
        obj.addNum(-5);
        System.out.println(obj.findMedian());

        MedianFinder obj_2 = new MedianFinder();
        obj_2.addNum(2);
        System.out.println(obj_2.findMedian());
        obj_2.addNum(3);
        System.out.println(obj_2.findMedian());
    }
}

class MedianFinder {
    private PriorityQueue<Integer> pqMIN;
    private PriorityQueue<Integer> pqMAX;

    public MedianFinder() {
        pqMIN = new PriorityQueue<>();
        pqMAX = new PriorityQueue<>((x, y) -> y - x);
    }
    
    public void addNum(int num) {
       pqMAX.add(num);
       pqMIN.add(pqMAX.poll());
       if (pqMIN.size() > pqMAX.size()) {
           pqMAX.add(pqMIN.poll());
       }
    }
    
    public double findMedian() {
        if (pqMIN.size() == pqMAX.size()) {
            return (pqMAX.peek() + pqMIN.peek()) / 2.0;
        } else return pqMAX.peek();
    }
}