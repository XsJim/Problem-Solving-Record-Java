public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode.pr(root);
        root = new Solution().insertIntoBST(root, 5);
        System.out.println("----------");
        TreeNode.pr(root);
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

    public static void pr(TreeNode node) {
        if (node == null) return;
        pr(node.left);
        System.out.println(node.val);
        pr(node.right);
    }
}

// 首先创造新结点
// 然后在搜索树中找到适合插入该结点的父结点
// 然后将其插入父结点左右子结点的合适位置
// 返回当前树的根结点即可
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode tNew = new TreeNode(val);
        TreeNode p = talgo(root, val);
        if (p == null) return tNew;
        if (p.val > val) {
            p.left = tNew;
        } else p.right = tNew;
        return root;
    }

    private static TreeNode talgo(TreeNode node, int val) {
        if (node == null) return null;
        if (node.val > val) {
            TreeNode re = talgo(node.left, val);
            return re == null ? node : re;
        } else {
            TreeNode re = talgo(node.right, val);
            return re == null ? node : re;
        }
    }
}