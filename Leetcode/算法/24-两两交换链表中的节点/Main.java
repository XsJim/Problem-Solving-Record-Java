public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = new Solution().swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode new_head = new ListNode(-1);
        new_head.next = head;

        ListNode prev = new_head;
        ListNode first = null, second = null;
        if (head != null) {
            first = head;
            second = head.next;
        }

        while (second != null) {
            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            if (first.next != null) {
                first = first.next;
                second = first.next;
            } else break;
        }

        return new_head.next;
    }
}