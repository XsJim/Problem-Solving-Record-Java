public class Main {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(3);
        A.right = new TreeNode(6);
        A.left.left = new TreeNode(2);
        A.left.right = new TreeNode(4);
        A.right.left = null;
        A.right.right = null;

        A.left.left.left = new TreeNode(1);
        A.left.left.right = null;
        A.left.right.left = null;
        A.left.right.right = null;
        A.left.left.left.left = null;
        A.left.left.left.right = null;
        System.out.println((new Solution().lowestCommonAncestor(A, A.left, A.right)).val);
        System.out.println((new Solution().lowestCommonAncestor(A, A.left, A.left.right)).val);
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val < q.val) {
            return talgo(root, p, q);
        } else {
            return talgo(root, q, p);
        }
        
    }

    private static TreeNode talgo(TreeNode x, TreeNode p, TreeNode q) {
        if (p.val <= x.val && q.val >= x.val) return x;
        if (p.val < x.val) {
            return talgo(x.left, p, q);
        } else {
            return talgo(x.right, p, q);
        }
    }
}