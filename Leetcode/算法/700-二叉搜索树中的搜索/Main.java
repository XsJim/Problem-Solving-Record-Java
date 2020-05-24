public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode se = new Solution().searchBST(root, 2);
        TreeNode.pre(se);
        System.out.println("#");
        se = new Solution().searchBST(root, 5);
        TreeNode.pre(se);
    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val > val) return searchBST(root.left, val);
        else if (root.val < val) return searchBST(root.right, val);
        else return root;
    }
}