public class Main {
    public static void main(String[] args) {
        TreeNode head = new Solution().sortedArrayToBST(new int[] {-10,-3,0,5,9});
        TreeNode.lev(head);
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createMinimalTree(nums, 0, nums.length-1);
    }

    private static TreeNode createMinimalTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right + 1) / 2;
        TreeNode re = new TreeNode(nums[mid]);
        re.left = createMinimalTree(nums, left, mid-1);
        re.right = createMinimalTree(nums, mid+1, right);
        return re;
    }
}