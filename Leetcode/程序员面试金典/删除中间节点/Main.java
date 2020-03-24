public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode current = l1;
        l1.next = new ListNode(10);
        l1.next.next = new ListNode(11);
        l1.next.next.next = new ListNode(12);
        l1.next.next.next.next = new ListNode(13);
        l1.next.next.next.next.next = null;

        new Solution().deleteNode(l1.next.next);

        while (current != null) {
            System.out.print(current.val+" ");
            current = current.next;
        }

    }
}

class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        if (node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}