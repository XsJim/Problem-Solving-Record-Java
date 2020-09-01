public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head = new Solution().deleteDuplicates(head);
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
    // 找到排序链表中相同的数，将它们都删除
    // 创建一个链表结点，它的下一个元素是当前检测的元素
    // 创建一个链表对象，存放当前元素的下一个元素
    // 每轮判断，都判断当前元素和下一个元素是否相同
    // 如果相同，将计数器加 1 ，再将下一个元素变为下下个元素，继续判断
    // 如果不同，首先判断计数器是否为 0
    // -如果为 0 ，说明当前元素只有一个，则将前一个元素变为当前元素，当前元素变为当前元素的下一个，下一个元素变为新的当前元素的下一个
    // -如果不为 0，则说明当前元素不止一个，要将其全部删除，所以将前一个元素的下一个元素指向下一个元素，前一个元素不变
    // -当前元素变为下一个元素，下一个元素变为新的当前元素的下一个元素
    // 循环判断的结束条件是下一个元素是否为 null
    // 如果链表最后一部分的元素相同，则在判断到最后一个元素后，就将退出循环
    // 这时最后一部分相同元素不会被删除
    // 所以在退出循环后，要再判断一次计数器是否为 0
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode nHead = new ListNode(-1);
        nHead.next = head;
        ListNode prev = nHead;
        ListNode current = head;
        ListNode cNext = current.next;
        int x = 0;
        while (cNext != null) {
            if (current.val == cNext.val) {
                cNext = cNext.next;
                x++;
            } else {
                if (x > 0) {
                    prev.next = cNext;
                    x = 0;
                } else prev = current;
                current = cNext;
                cNext = current.next;
            }
        }

        if (x > 0) prev.next = cNext;

        return nHead.next;
    }
}