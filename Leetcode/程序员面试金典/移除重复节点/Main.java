import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = null;
        head = new Solution().removeDuplicateNodes(head);
        ListNode current = head;

        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}

class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (ListNode current = head, prev = null; current != null; current = current.next) {
            if (hashMap.containsKey(current.val)) {
                prev.next = current.next;
            } else {
                hashMap.put(current.val, 1);
                prev = current;
            }
        }
        return head;
    }
}