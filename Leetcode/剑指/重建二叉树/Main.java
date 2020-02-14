public class Main {
    public static void main(String[] args) {
        int[] preorder = {3,20,15,7};
        int[] inorder = {3,15,20,7};
        Solution solution = new Solution();
        TreeNode.print(solution.buildTree(preorder, inorder));
    } 
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return talgo(preorder, inorder, 0, 0, inorder.length);
    }

    private static TreeNode talgo(int[] preorder, int[] inorder, int x, int y, int z) {
        if (z < y || x >= preorder.length) return null;
        TreeNode newNode = new TreeNode(preorder[x]);
        int i = y;
        while (i <= z) {
            if (inorder[i] == preorder[x]) break;
            i++;
        }
        newNode.left = talgo(preorder, inorder, x+1, y, i-1);
        newNode.right = talgo(preorder, inorder, x+i-y+1, i+1, z);
        return newNode;
    }
}