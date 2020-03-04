public class Main {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(4);
        A.right = new TreeNode(8);
        A.left.left =new TreeNode(11);
        A.left.right = null;
        A.right.left = new TreeNode(13);
        A.right.right = new TreeNode(4);

        A.left.left.left = new TreeNode(7);
        A.left.left.right = new TreeNode(2);
        //A.left.right.left = null;
        //A.left.right.right = null;
        A.right.left.left = null;
        A.right.left.right = null;
        A.right.right.left = new TreeNode(5);
        A.right.right.left.left = null;
        A.right.right.left.right = null;
        A.right.right.right = new TreeNode(1);
        A.right.right.right.left = null;
        A.right.right.right.right = null;
        System.out.println(new Solution().isBalanced(A));
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(talgo(root.left) - talgo(root.right)) < 2
           && isBalanced(root.left)
           && isBalanced(root.right);
    }

    private static int talgo(TreeNode x) {
        if (x == null) return 0;
        return 1 + Math.max(talgo(x.left), talgo(x.right));
    }
}