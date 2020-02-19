public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = null;
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
        head = new Solution().deleteNode(head, 9);
        current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) {
            head = head.next;
        } else {
            ListNode prev = head;
            ListNode current = head.next;
            while (current != null) {
                if (current.val == val) {
                    prev.next = current.next;
                    break;
                }
                prev = current;
                current = current.next;
            }
        }
        return head;
    }
}