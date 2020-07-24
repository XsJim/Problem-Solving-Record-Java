public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        System.out.println(new Solution().findBottomLeftValue(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int[] max = new int[1];
        int[] ans = new int[1];
        talgo(root, max, 1, ans);

        return ans[0];
    }
    
    private static void talgo(TreeNode node, int[] max, int h, int[] ans) {
        if (node == null) return;
        if (h > max[0]) {
            ans[0] = node.val;
            max[0] = h;
        }
        talgo(node.left, max, h+1, ans);
        talgo(node.right, max, h+1, ans);
    }
}