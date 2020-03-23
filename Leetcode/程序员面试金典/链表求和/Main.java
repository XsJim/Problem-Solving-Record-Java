public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = null;

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = null;

        ListNode l3 = new Solution().addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val+" ");
            l3 = l3.next;
        }

    }
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode first = l1, second = l2, prev = head;
        int carry = 0;
        while (first != null || second != null) {
            int a = (first != null) ? first.val : 0;
            int b = (second != null) ? second.val : 0;
            int sum = a + b + carry;

            prev.next = new ListNode(sum % 10);
            carry = sum / 10;

            prev = prev.next;
            
            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }

        if (carry > 0) prev.next = new ListNode(carry);

        return head.next;
    }
}