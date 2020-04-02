public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new Solution().kthToLast(head, 2));
    }
}

class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode left = head, right = head;
        for (int i = 1; i < k; i++) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        return left.val;
    }
}