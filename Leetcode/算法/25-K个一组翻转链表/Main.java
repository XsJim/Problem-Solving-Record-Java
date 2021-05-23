public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = new Solution().reverseKGroup(head, 2);
        // ListNode newHead = new Solution().reverseKGroup(head, 3);

        ListNode current = newHead;

        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// 整体上分为两个步骤：
// 1. 读取一段符合反转条件的链表
// 2. 反转它
// 接下来详细说一下每一步：
// 1. 读取一段符合反转条件的链表
//   1. 已经存在一个变量 x ，这个变量指向当前这段链表头的前一个结点，用于之后反转一段链表后，将反转后的链表拼接到原链表中
//   2. 从当前头开始遍历链表结点，将当前访问结点定义为 y ，当到达链表尾部或者计数器达到 k 时，结束遍历
//   3. 判断计数器的值，如果计数器的值等于 k ，说明这段链表可以反转，它的头是 x 表示的结点的下一个结点，它的尾是 y 表示的结点，需要保存这对头尾结点，以及尾结点之后的第一个结点，以便反转之后进行拼接
//   4. 反转这段链表
//     1. 依次改变结点的 next 值为结点的上一个元素，以便完成反转
//   5. 将反转后的链表拼接到原链表中，由于这段链表已经反转，所以它原来的头现在是尾，原来的尾现在是头，利用已有变量将其拼接，并更新 x 的值
//   6. 继续 1 ~ 5 的步骤直到到达链表尾部或者当前段不足以反转
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode prevTail = newHead;

        int count = k;
        while (count == k && prevTail.next != null) {
            ListNode tail = prevTail;
            count = 0;

            while (tail.next != null && count < k) {
                tail = tail.next;
                count++;
            }

            if (count == k) {
                ListNode currentHead = prevTail.next;
                ListNode nextHead = tail.next;

                reverse(currentHead, tail);

                prevTail.next = tail;
                currentHead.next = nextHead;

                prevTail = currentHead;
            }
        }

        return newHead.next;
    }

    private static void reverse(ListNode head, ListNode tail) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        tail.next = null;
        while (current != null) {
            next = current.next;

            current.next = prev;

            prev = current;

            current = next;
        }
    }
}