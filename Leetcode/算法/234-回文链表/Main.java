public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(new Solution().isPalindrome(head));
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(new Solution().isPalindrome(head));
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
    // 判断链表是否为回文链表
    // 分为 5 步：
    // 首先将计算链表长度
    // 然后根据链表长度得到链表中心结点（长度为偶数，就找前半段的最后一个结点，长度为奇数，就找到中心得那一个）
    // 反转后半段链表
    // 将前半段和后半段进行比较，确定链表是否为回文链表
    // 再次反转后半段链表，将链表恢复初始状态
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int len = 0;
        ListNode current = head;
        while (current != null) {
            len++;
            current = current.next;
        }
        if (len == 1) return true;

        ListNode mid = head;

        int count = len / 2;
        if ((len & 1) == 1) count++;
        while (count != 1) {
            mid = mid.next;
            count--;
        }

        change(mid);

        boolean ans = true;
        ListNode first = head;
        current = mid.next;
        while (current != null) {
            if (first.val != current.val) {
                ans = false;
                break;
            }
            first = first.next;
            current = current.next;
        }

        change(mid);

        return ans;
    }

    private static void change(ListNode mid) {
        ListNode prev = mid.next;
        if (prev.next != null) {
            ListNode current = prev.next;
            prev.next = null;
            while (current != null) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            mid.next = prev;
        }
    }
}