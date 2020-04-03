public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(-1);
        l1.next.next.next.next = l1.next;
        System.out.println(new Solution().detectCycle(l1).val);

    }
}


class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
}