public class Main {
    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        System.out.println(new Solution().isSubtree(s, t));
    }
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
}

class Solution {
    // 大致的思路是这样的
    // 检查 s 中每一个结点，一旦当前结点的值和给定的 t 的根结点的值相同，就去检查从 s 中当前结点开始的子树，是否和 t 完全相同
    // 这一过程用到了两种不同的逻辑：
    // 检查当前结点和 t 的根结点是否相同
    // 检查当前结点和 t 的当前结点是否相同
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val == t.val && check(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && check(s.left, t.left) && check(s.right, t.right);
    }
}