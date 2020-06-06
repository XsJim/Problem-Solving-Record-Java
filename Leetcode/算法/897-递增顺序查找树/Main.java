public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(8);

        root.left.left.left = new TreeNode(1);

        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        root = new Solution().increasingBST(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }
}

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(-1);
        TreeNode[] current = new TreeNode[1];
        current[0] = ans;
        mid(root, current);
        return ans.right;
    }

    private void mid(TreeNode node, TreeNode[] current) {
        if (node == null) return;
        mid(node.left, current);
        node.left = null;
        current[0].right = node;
        current[0] = node;
        mid(node.right, current);
    }
}