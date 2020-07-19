public class Main {
    public static void main(String[] args) {
        TreeNode root = new Solution().constructMaximumBinaryTree(new int[] {3,2,1,6,0,5});
        TreeNode.pr(root);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static void pr(TreeNode tn) {
        if (tn == null) return;
        System.out.println(tn.val);
        pr(tn.left);
        pr(tn.right);
    }
}

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return talgo(nums, 0, nums.length-1);
    }

    private static TreeNode talgo(int[] nums, int l, int r) {
        if (l > r) return null;
        int max = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[max] < nums[i]) max = i;
        }
        TreeNode x = new TreeNode(nums[max]);

        x.left = talgo(nums, l, max-1);
        x.right = talgo(nums, max+1, r);

        return x;
    }
}