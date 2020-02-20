public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
        current = new Solution().reverseList(head);
        System.out.println("----");
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reHead = null;
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            reHead = current;
            current = current.next;
            reHead.next = prev;
            prev = reHead;
        }
        return reHead;
    }
}