public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);

        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);

        root.right.right.right = new TreeNode(5);

        System.out.println(new Solution().sumEvenGrandparent(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        int[] sum = new int[1];
        talgo(root, sum);

        return sum[0];
    }

    private static void talgo(TreeNode node, int[] sum) {
        if (node == null) return;

        if ((node.val & 1) == 0) {
            if (node.left != null) {
                if (node.left.left != null) sum[0] += node.left.left.val;
                if (node.left.right != null) sum[0] += node.left.right.val;
            }
            if (node.right != null) {
                if (node.right.left != null) sum[0] += node.right.left.val;
                if (node.right.right != null) sum[0] += node.right.right.val;
            }
        }

        talgo(node.left, sum);
        talgo(node.right, sum);
    }
}