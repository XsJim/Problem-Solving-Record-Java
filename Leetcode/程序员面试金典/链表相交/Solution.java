public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lengthA = 0, lengthB = 0;
        ListNode currentA = headA;
        ListNode currentB = headB;
        ListNode prevA = null, prevB = null;
        while (currentA != null) {
            lengthA++;
            prevA = currentA;
            currentA = currentA.next;
        }
        while (currentB != null) {
            lengthB++;
            prevB = currentB;
            currentB = currentB.next;
        }
        if (prevA != prevB) return null;

        if (lengthA > lengthB) {
            currentA = headA;
            currentB = headB;
        } else {
            currentA = headB;
            currentB = headA;
        }

        for (int i = 0; i < Math.abs(lengthA - lengthB); i++) {
            currentA = currentA.next;
        }
        while (currentA != currentB) {
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return currentA;
    }
}