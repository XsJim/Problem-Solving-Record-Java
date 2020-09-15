import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}

// 一个日程可以被添加
// 需要这个日程的半闭半开时间段不与现存的所有时间段交叉
// 如果将现存的时间段按照开始时间从小到大排列，判断时会更加方便
// 当一个时间段要添加到当前日程中时
// 从前至后遍历链表
// 如果添加事件的起始时间要比当前事件的结束时间还要大（或等于），说明添加事件要加入日程也是在当前事件之后
// 否则，继续判断
//   此时添加事件的起始时间要小于当前事件的结束时间
//   如果添加事件的结束时间小于当前事件的起始时间，说明此事件可以添加
//   否则，此事件不可添加
// 如果当前所有事件的结束时间都小于等于添加事件的起始时间，说明添加事件可以被添加到日程表中

class MyCalendar {
    private List<Node> list;

    class Node {
        int nStart;
        int nEnd;
        Node(int nStart, int nEnd) {
            this.nStart = nStart;
            this.nEnd = nEnd;
        }
    }

    public MyCalendar() {
        list = new ArrayList<Node>();
    }
    
    public boolean book(int start, int end) {
        int i = 0;
        for (Node node : list) {
            if (start < node.nEnd) {
                if (end > node.nStart) return false;
                list.add(i, new Node(start, end));
                return true;
            }
            i++;
        }
        list.add(new Node(start, end));
        return true;
    }
}