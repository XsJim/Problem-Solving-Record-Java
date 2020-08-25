public class Main {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        ListNode head =  new Solution().mergeKLists(lists);

        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }


        lists = new ListNode[0];
        
        head =  new Solution().mergeKLists(lists);

        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }

        lists = new ListNode[1];
        
        head =  new Solution().mergeKLists(lists);

        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
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

class Solution {
    // 递归合并
    // 将所有有序链表合并为一个
    // 逐个将相邻链表合并为一个
    // 每次合并时有两个链表
    // 合并两个链表采用递归方法
    // 合并方法返回两个链表合并后的链表头
    // 如果第一个链表头为空，那么合并后的链表头为第二个链表的头
    // 如果第二个链表头为空，那么合并后的链表头为第一个链表的头
    // 如果两链表都不为空，则需要比较值：
    // 哪个值较小，则哪个就是此次递归该返回的头
    // 确定了返回的链表头，就要继续将剩余的链表进行合并
    // 合并的部分是除去作为头反回的结点，和另一个链表的全部
    // 将这剩余的两部分通过递归合并后，返回的便是合并后的头
    // 将这个头和当前要返回的头连接，就完成了两个链表的合并
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = merge(head, lists[i]);
        }

        return head;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (head1.val <= head2.val) {
            head1.next = merge(head1.next, head2);
            return head1;
        }
        head2.next = merge(head1, head2.next);
        return head2;
    }

    // 哈希表
    // 设立两个数组，一个存放相同数字结点的链表头，一个存放表尾
    // 遍历链表，如果当前数字的头已经存在，将其连接到对应的表尾，并将表尾改为它
    // 否则，将其设为表头和表尾
    // 一次遍历之后，再次遍历链表头数组，如果表头存在，则将其连接到主链表，再将对应的链表尾设为主链表的最后一个结点，以便之后的连接
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode[] heads = new ListNode[20001];
        ListNode[] ends = new ListNode[20001];
        for (int i = 0; i < lists.length; i++) {
            ListNode current = lists[i];
            while (current != null) {
                int x = current.val+10000;
                if (heads[x] == null) {
                    heads[x] = current;
                    current = current.next;
                    heads[x].next = null;
                    ends[x] = heads[x];
                } else {
                    ends[x].next = current;
                    ends[x] = current;
                    current = current.next;
                    ends[x].next = null;
                }
            }
        }
        ListNode head = new ListNode(-1);
        ListNode current = head;
        for (int i = 0; i < 20001; i++) {
            if (heads[i] != null) {
                current.next = heads[i];
                current = ends[i];
            }
        }

        return head.next;
    }
}