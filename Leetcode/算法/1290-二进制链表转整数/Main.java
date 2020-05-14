public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(new Solution().getDecimalValue(head));
    }
}

class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans <<= 1;
            ans |= head.val;
            head = head.next;
        }
        return ans;
    }
}