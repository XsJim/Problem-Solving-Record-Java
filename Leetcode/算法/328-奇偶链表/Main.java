public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = new Solution().oddEvenList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode first = head;
        ListNode head_2 = head.next;
        ListNode second = head_2;
        while (second != null && second.next != null) {
            first.next = second.next;
            first = first.next;
            second.next = second.next.next;
            second = second.next;
            first.next = head_2;
        }
        return head;
    }
}