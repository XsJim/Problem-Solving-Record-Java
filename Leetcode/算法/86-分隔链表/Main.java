public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head = new Solution().partition(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    // 遍历链表，创建两个头
    // 每轮首先创建主链表当前结点的副本
    // 如果当前元素小于给定的 x 就将副本插入头一
    // 如果当前元素大于等于给定的 x 就将副本插入头二
    // 最终，将头二连接到头一的末尾元素之后即可
    public ListNode partition(ListNode head, int x) {
        ListNode o1 = new ListNode(-1);
        ListNode o2 = new ListNode(-1);

        ListNode current = head;
        ListNode o1_current = o1;
        ListNode o2_current = o2;
        while (current != null) {
            ListNode ne = new ListNode(current.val);
            if (current.val < x) {
                o1_current.next  = ne;
                o1_current = ne;
            } else {
                o2_current.next = ne;
                o2_current = ne;
            }
            current = current.next;
        }
        o1_current.next = o2.next;
        return o1.next;
    }
}