public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        System.out.println(new Solution().numComponents(head, new int[] {0, 1, 3}));

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    // 遍历链表计算链表长度
    // 由于链表、数组中元素都在 0 ~ (N-1) 的范围内，所以创建长度为 N 的数组 flag 来标记某一元素是否出现在 G 数组中
    // 遍历 G 数组并将当前元素在 flag 数组中标记为 true ，表示元素存在
    // 再次遍历链表，结合 flag 数组，判断链表中可相连元素段的个数
    public int numComponents(ListNode head, int[] G) {
        int len = 0;
        ListNode current = head;
        while (current != null) {
            len++;
            current = current.next;
        }

        boolean[] flag = new boolean[len];

        for (int i = 0; i < G.length; i++) flag[G[i]] = true;

        int ans = 0;
        int current_len = 0;
        current = head;
        while (current != null) {
            if (flag[current.val]) {
                current_len++;
            }
            else if (current_len != 0) {
                ans++;
                current_len = 0;
            }
            current = current.next;
        }

        if (current_len != 0) ans++;

        return ans;
    }
}