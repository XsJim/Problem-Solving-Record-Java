public class Main {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = null;
        ListNode headB = new ListNode(1);
        headB.next = headA.next;
        System.out.println(new Solution().getIntersectionNode(headA, headB).val);
    }
}