public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1000000);
        list2.next = new ListNode(1000001);
        list2.next.next = new ListNode(1000002);
        ListNode head = new Solution().mergeInBetween(list1, 3, 4, list2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// 首先给list1添加一个新头
// 再得到删除区间的前一个结点和后一个结点
// 再得到list2的末尾结点
// 然后通过拼接list1删除区间前一个结点->list2头结点，list2末尾结点->list1删除区间后一个结点
// 得到新的链表，返回新创建的头的下一个结点即可
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = new ListNode();
        head.next = list1;
        ListNode l1s = head;
        int i = 0;
        while (i < a) {
            l1s = l1s.next;
            i++;
        }
        ListNode l1e = l1s.next;
        while (i <= b) {
            l1e = l1e.next;
            i++;
        }
        ListNode l2e = list2;
        while (l2e.next != null) l2e = l2e.next;

        l1s.next = list2;
        l2e.next = l1e;

        return head.next;
    }
}