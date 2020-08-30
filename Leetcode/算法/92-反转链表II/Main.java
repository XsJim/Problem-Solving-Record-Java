public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = new Solution().reverseBetween(head, 2, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    // 反转链表的一部分
    // 首先找到要反转的链表区间的头部的前一个元素
    // 然后从该元素的下一个元素开始，反转链表，直到到达反转区间的结尾
    // 将该结尾连接到反转区间开始元素的前一个元素
    // 将该区间开始元素的指向下一个元素的指针指向区间结束的后一个元素
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode nHead = new ListNode(-1);
        nHead.next = head;
        ListNode prev = nHead;
        int i = 1;
        while (i != m) {
            prev = prev.next;
            i++;
        }

        ListNode nPrev = prev.next;
        if (nPrev.next != null) {
            ListNode current = nPrev.next;
            while (i != n) {
                ListNode temp = current.next;
                current.next = nPrev;
                nPrev = current;
                current = temp;
                i++;
            }
            prev.next.next = current;
            prev.next = nPrev;
        }
        return nHead.next;
    }
}