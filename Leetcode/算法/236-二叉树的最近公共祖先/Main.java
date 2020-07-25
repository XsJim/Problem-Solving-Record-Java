import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(new Solution().lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(new Solution().lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        talgo(root, p, stack, new boolean[1]);
        TreeNode prev = null;
        while (!stack.empty()) {
            TreeNode n = stack.pop();
            if (find(n, q, prev)) return n;
            prev = n;
        }
        return null;
    }

    private static void talgo(TreeNode node, TreeNode find, Stack<TreeNode> stack, boolean[] flag) {
        if (node == null) return;
        stack.push(node);
        if (node == find) {
            flag[0] = true;
            return;
        }
        talgo(node.left, find, stack, flag);
        if (flag[0]) return;
        talgo(node.right, find, stack, flag);
        if (flag[0]) return;
        stack.pop();
    }

    private static boolean find(TreeNode node, TreeNode tfind, TreeNode t) {
        if (node == null || node == t) return false;
        if (node == tfind) return true;
        return find(node.left, tfind, t) || find(node.right, tfind, t);
    }
}