public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new Solution().isSymmetric(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // 检测给定的二叉树是否镜像对称
    // 递归法：
    // 确定给定的根结点的左右子树对称
    // 首先需要判断左右两个结点是否相同
    // 其次需要判断左结点的左子树和右结点的右子树、左结点的右子树和右结点的左子树是否对称
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return talgo(root.left, root.right);
    }

    private static boolean talgo(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return talgo(node1.left, node2.right) && talgo(node1.right, node2.left);
    }
}