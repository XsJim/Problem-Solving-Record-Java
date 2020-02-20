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
        current = new Solution().getKthFromEnd(head, 2);
        System.out.println("----");
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode current = head;
        int i = 0;
        while (current != null) {
            i++;
            current = current.next;
        }
        i -= k;
        i++;
        int j = 1;
        current = head;
        while (j != i) {
            current = current.next;
            j++;
        }
        return current;
    }
}