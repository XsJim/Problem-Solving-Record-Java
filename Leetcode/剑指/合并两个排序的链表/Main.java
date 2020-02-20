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
        ListNode head_1 = new ListNode(1);
        head_1.next = new ListNode(3);
        head_1.next.next = new ListNode(4);
        head_1.next.next.next = new ListNode(6);
        head_1.next.next.next.next = new ListNode(7);
        head_1.next.next.next.next.next = null;
        System.out.println("----");
        current = head_1;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
        current = new Solution().mergeTwoLists(head, head_1);
        System.out.println("----");
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode re;
        if (l1.val < l2.val) {
            re = l1;
            l1 = l1.next;
        } else {
            re = l2;
            l2 = l2.next;
        }
        ListNode current = re;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return re;
    }
}