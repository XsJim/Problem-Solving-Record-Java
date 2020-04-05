public class Main {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(9);
        A.right = new TreeNode(20);
        A.left.left =new TreeNode(11);
        A.left.right =new TreeNode(13);
        A.left.left.left = new TreeNode(12);

        System.out.println(new Solution().isBalanced(A));
    }
}


class Solution {
    public boolean isBalanced(TreeNode root) {
        if (talgo(root) < 0) return false;
        return true;
    }

    private static int talgo(TreeNode node) {
        if (node == null) return 0;
        int left = talgo(node.left);
        if (left < 0) return -1;
        int right = talgo(node.right);
        if (right < 0) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}