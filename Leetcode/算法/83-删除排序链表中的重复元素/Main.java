public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head = new Solution().deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head = new Solution().deleteDuplicates(head);
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
    // 删除排序链表中的相同元素，只留下一个
    // 设置两个指针，初始值为链表头，和链表头的后一个
    // 检测当前两个指针的值，总有两种情况：
    // 两值相等，说明需要删除一值，按照算法的思路，这时第一个指针指向的，应该是这个值的首次出现，所以删除后一个
    // 两值不等，说明当前第一个指针指向的，已经是当前链表中唯一的，所以两指针同时后移
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode prev = head;
        ListNode current = head.next;
        while (current != null) {
            if (prev.val == current.val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}