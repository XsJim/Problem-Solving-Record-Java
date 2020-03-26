public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = null;
        ListNode current = new Solution().partition(head, 5);

        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}


class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode minListHead = new ListNode(-1);
        ListNode maxListHead = new ListNode(-1);
        ListNode minCurrent = minListHead;
        for (ListNode current = head, maxCurrent = maxListHead; current != null; current = current.next) {
            if (current.val < x) {
                minCurrent.next = new ListNode(current.val);
                minCurrent = minCurrent.next;
            } else {
                maxCurrent.next = new ListNode(current.val);
                maxCurrent = maxCurrent.next;
            }
        }
        if (minListHead.next == null) return maxListHead.next;
        minCurrent.next = maxListHead.next;
        return minListHead.next;
    }
}