public class Main {
    public static void main(String[] args) {
        TreeNode.pre(new Solution().sortedArrayToBST(new int[] {-10,-3,0,5,9}));
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return talgo(0, nums.length-1, nums);
    }

    private static TreeNode talgo(int left, int right, int[] nums) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = talgo(left, mid-1, nums);
        node.right = talgo(mid+1, right, nums);
        return node;
    }
}