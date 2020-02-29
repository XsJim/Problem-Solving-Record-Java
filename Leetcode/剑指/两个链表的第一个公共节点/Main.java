public class Main {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headB.next.next.next = headA.next.next;
        headA.next.next.next = new ListNode(4);
        headB.next.next.next.next = headA.next.next.next;
        headA.next.next.next.next = new ListNode(5);
        headB.next.next.next.next.next = headA.next.next.next.next;
        headA.next.next.next.next.next = null;
        headB.next.next.next.next.next.next = headA.next.next.next.next.next;
        ListNode re = new Solution().getIntersectionNode(headA, headB);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int a = 0;
        int b = 0;
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (currentA != null) {
            a++;
            currentA = currentA.next;
        }
        while (currentB != null) {
            b++;
            currentB = currentB.next;
        }
        currentA = headA;
        currentB = headB;
        if (a > b) {
            for (int i = 0; i < (a - b) ; i++) {
                currentA = currentA.next;
            }
        } else {
            for (int i = 0; i < (b - a) ; i++) {
                currentB = currentB.next;
            }
        }
        while (currentA != null && currentA != currentB) {
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return currentA;
    }
}