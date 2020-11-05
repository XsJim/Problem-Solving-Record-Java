public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        new Solution().reorderList(head);
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
// 遍历链表，记录长度
// 创建相同长度的链表结点数组，再次遍历链表，将每个结点加入数组中
// 之后依照要求的重排顺序组装链表
class Solution {
    public void reorderList(ListNode head) {
        ListNode current = head;
        int len = 0;
        while (current != null) {
            len++;
            current = current.next;
        }
        ListNode[] list = new ListNode[len];
        current = head;
        for (int i = 0; i < len; i++) {
            list[i] = current;
            current = current.next;
        }
        current = new ListNode();
        int i = 0, j = len - 1;
        while (i < j) {
            current.next = list[i];
            list[i].next = list[j];
            current = list[j];
            i++;
            j--;
        }
        if (i == j) {
            current.next = list[i];
            current = list[i];
        }
        current.next = null;
    }
}