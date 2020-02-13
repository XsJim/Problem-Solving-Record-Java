import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = null;
        System.out.println(Arrays.toString(new Solution().reversePrint(head)));
    }
}

class Solution {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            arrayList.add(current.val);
            current = current.next;
        }
        int[] re = new int[arrayList.size()];
        for (int i = arrayList.size() - 1, j = 0; i >= 0; i--, j++) {
            re[j] = arrayList.get(i);
        }
        return re;
    }
}