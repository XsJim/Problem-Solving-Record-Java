public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        root.left.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(8);
        TreeNode.p(root);
        System.out.println();
        root = new Solution().bstToGst(root);
        TreeNode.p(root);
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

    public static void p(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val+" ");
        p(node.left);
        p(node.right);
    }
}

// 首先得到二叉搜索树的中序遍历序列（排序序列）
// 然后由尾至始计算后缀和
// 再次遍历二叉搜索树，将每一个结点对应的后缀和重新填充结点
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        int[] flag = new int[101];
        for (int i = 0; i < flag.length; i++) flag[i] = -1;
        p(root, flag);
        for (int i = flag.length-1, prev = 0; i >= 0; i--) {
            if (flag[i] == 1) {
                flag[i] = i + prev;
                prev = flag[i];
            }
        }

        t(root, flag);
        return root;
    }

    private static void p(TreeNode node, int[] flag) {
        if (node == null) return;
        flag[node.val] = 1;
        p(node.left, flag);
        p(node.right, flag);        
    }

    private static void t(TreeNode node, int[] flag) {
        if (node == null) return;
        node.val = flag[node.val];
        t(node.left, flag);
        t(node.right, flag);        
    }
}