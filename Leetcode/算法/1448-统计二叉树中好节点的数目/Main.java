public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(new Solution().goodNodes(root));
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

// 递归的进行检测
// 如果当前结点的值比到达它的路径上的最大值大，则在检测它的后代元素的递归中，将最大值替换为它的值
class Solution {
    public int goodNodes(TreeNode root) {
        int[] ans = new int[1];
        talgo(root, root.val, ans);
        return ans[0];
    }

    private static void talgo(TreeNode node, int max, int[] ans) {
        if (node == null) return;
        if (node.val >= max) {
            ans[0]++;
            max = node.val;
        }

        talgo(node.left, max, ans);
        talgo(node.right, max, ans);
    }
}