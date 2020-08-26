public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode root = new Solution().sortedListToBST(head);
        TreeNode.p(root);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void p(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        p(node.left);
        p(node.right);
    }
}

class Solution {
    // 如果给定的是排序后的数组
    // 用它构造一个平衡的二叉搜索树
    // 只需使用递归方法，每次取数组中部靠后的元素作为当前树结点，此元素左半部分递归构造左子树，右半部分递归构造右子树
    // 而得到链表对应的数组，只需两次遍历链表即可
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode current = head;
        while (current != null) {
            n++;
            current = current.next;
        }
        int[] list = new int[n];
        current = head;
        n = 0;
        while (current != null) {
            list[n++] = current.val;
            current = current.next;
        }

        return talgo(list, 0, n-1);
    }

    private static TreeNode talgo(int[] list, int l, int r) {
        if (l > r) return null;
        int mid = (l + r + 1) / 2;
        TreeNode current = new TreeNode(list[mid]);
        current.left = talgo(list, l, mid-1);
        current.right = talgo(list, mid+1, r);
        return current;
    }
}