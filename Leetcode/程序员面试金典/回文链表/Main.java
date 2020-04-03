import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(1);
        System.out.println(new Solution().isPalindrome(l1));

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(1);
        System.out.println(new Solution().isPalindrome(l2));

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(3);
        System.out.println(new Solution().isPalindrome(l3));
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode current = head;
        while (current != null) {
            len++;
            current = current.next;
        }
        int mid = len / 2;
        current = head;
        for (int i = 0; i < mid; i++) {
            current = current.next;
        }
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        current = head;
        for (int i = 0; i < mid; i++) {
            if (current.val != stack.pop().val) return false;
            current = current.next;
        }
        return true;
    }
}