public class Main {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(2);
        A.left.left = new TreeNode(3);
        A.right.right = new TreeNode(3);

        A.left.right = null;
        A.right.left = null;
        A.left.left.left = null;
        A.left.left.right = null;
        A.right.right.left = null;
        A.right.right.right = null;
        System.out.println(new Solution().isSymmetric(A));
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return talgo(root.left, root.right);
    }

    private static boolean talgo(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return (a.val == b.val) && talgo(a.left, b.right) && talgo(a.right, b.left);
    }
}