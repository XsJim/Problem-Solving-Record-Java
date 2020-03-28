import java.util.ArrayDeque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(0);
        tree.left = new TreeNode(-3);
        tree.right = new TreeNode(9);
        tree.left.left = new TreeNode(-10);
        tree.left.right = null;
        tree.right.left = new TreeNode(5);
        tree.right.right = null;
        ListNode[] listNodes = new Solution().listOfDepth(tree);

        for (ListNode list : listNodes) {
            while (list != null) {
                System.out.print(list.val + " ");
                list = list.next;
            }
            System.out.println();
        }
    }
}

class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return null;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        LinkedList<ListNode> linkedList = new LinkedList<>();
        queue.add(tree);
        ListNode nowList = new ListNode(-1), listHead = nowList;
        int a = 1, b = 0;
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (a == 0) {
                linkedList.add(listHead.next);
                nowList = new ListNode(-1);
                listHead = nowList;
                a = b;
                b = 0;
            }
            if (current.left != null) {
                queue.add(current.left);
                b++;
            }
            if (current.right != null) {
                queue.add(current.right);
                b++;
            }
            nowList.next = new ListNode(current.val);
            nowList = nowList.next;
            a--;
        }

        if (listHead.next != null) linkedList.add(listHead.next);
        
        return linkedList.toArray(new ListNode[linkedList.size()]);
    }
}