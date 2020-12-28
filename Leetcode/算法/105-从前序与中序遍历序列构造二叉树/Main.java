public class Main {
    public static void main(String[] args) {
        TreeNode root = new Solution().buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
        TreeNode.p(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static void p(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        p(node.left);
        p(node.right);
    }
}

// 递归构造即可
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return talgo(preorder, 0, preorder.length-1, inorder, 0, inorder.length);
    }

    private static TreeNode talgo(int[] preorder, int p1, int p2, int[] inorder, int i1, int i2) {
        if (p1 > p2) return null;
        TreeNode cur = new TreeNode(preorder[p1]);
        int index = i1;
        while (index <= i2) {
            if (inorder[index] == preorder[p1]) break;
            index++;
        }

        cur.left = talgo(preorder, p1+1, p1+(index-i1), inorder, i1, index-1);
        cur.right = talgo(preorder, p1+(index-i1)+1, p2, inorder, index+1, i2);

        return cur;
    }
}