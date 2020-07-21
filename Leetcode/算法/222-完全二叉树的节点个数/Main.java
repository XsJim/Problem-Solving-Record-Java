public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(new Solution().countNodes(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = 0;
        TreeNode node = root;
        while (node.left != null) {
            h++;
            node = node.left;
        }

        int ans = (int)Math.pow(2, h) - 1;

        int left = 0, right = ans;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (find(root, mid, h)) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        return ans + left;
    }

    private static boolean find(TreeNode root, int f, int h) {
        int left = 0, right = (int)Math.pow(2, h) - 1;
        TreeNode node = root;
        for (int i = 0; i < h; i++) {
            int mid = (left + right) / 2;
            if (f <= mid) {
                node = node.left;
                right = mid - 1;
            } else {
                node = node.right;
                left = mid + 1;
            }
        }
        
        return node != null;
    }
}