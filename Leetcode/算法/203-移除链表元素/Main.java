public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        head = new Solution().removeElements(head, 6);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode nHead = new ListNode(-1);
        nHead.next = head;
        ListNode prev = nHead;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else prev = current;
            current = current.next;
        }
        return nHead.next;
    }
}