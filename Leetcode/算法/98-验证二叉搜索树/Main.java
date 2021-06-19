public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(4);
        // root.right.left = new TreeNode(3);
        // root.right.right = new TreeNode(6);
        System.out.println(new Solution().isValidBST(root));
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

// 对于二叉搜索树中的某一个结点，该结点左边的结点一定都小于该结点，该结点右边的值一定都大于该结点
// 假设当前检测的结点的值为 x
//     1. 首先依次检查结点左边的结点的值，确定它们都小于 x
//     2. 然后依次检查结点右边的结点的值，确定它们都大于 x
// 如果中序遍历二叉搜索树，得到的序列中，对于值为 x 的结点
//     1. 它左边的结点的值在序列中也都在它的左边
//     2. 它右边的结点的值在序列中也都在它的右边
// 那么，只要对于序列中的每个结点来说，只要它左边的值都小于它，它右边的值都大于它，那么就相当于符合一开始叙述的检查条件
// 如果一个序列的每个结点都符合上述情况，那这个序列一定是按升序排列的
// 所以只需检测二叉搜索树的中序遍历，看其是否符合升序即可
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean[] flag = new boolean[] {true};

        long[] top = new long[] {Long.MIN_VALUE};
        mid(top, flag, root);
        return flag[0];
    }

    private static void mid(long[] top, boolean[] flag, TreeNode node) {
        if (node == null || !flag[0]) return;
        mid(top, flag, node.left);
        if (!flag[0]) return;
        if (top[0] >= node.val) {
            flag[0] = false;
            return;
        }
        top[0] = node.val;
        mid(top, flag, node.right);
    }
}