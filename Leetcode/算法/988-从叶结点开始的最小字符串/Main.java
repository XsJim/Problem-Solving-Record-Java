public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(new Solution().smallestFromLeaf(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // 递归生成所有可能的字符串，在生成一个字符串后，与当前最字典序最小的字符串比较，如果这个新的字符串较小，则替换最小字符串
    // 前序遍历二叉树，遇到一个非空结点，先将它代表的字符插入结果数组中
    // 结果数组是倒序插入的，即先遇到的字符放在靠后的位置，这样保证生成的字符串的字符排列顺序是从树的叶到根
    // 插入结果数组后，判断当前结点是否为叶子结点
    // 如果是叶子，则说明当前可以生成一个字符串，且不可再继续向下递归
    // 如果不是叶子，则继续向下递归生成字符串
    public String smallestFromLeaf(TreeNode root) {
        String[] ans = new String[1];
        talgo(root, new char[8500], 8499, ans);
        return ans[0];
    }

    private static void talgo(TreeNode node, char[] box, int i, String[] ans) {
        if (node == null) return;
        box[i] = (char)(node.val + 'a');
        if (node.left == null && node.right == null) {
            String current = new String(box, i, box.length-i);
            if (ans[0] == null) ans[0] = current;
            else if (current.compareTo(ans[0]) < 0) ans[0] = current;
            return;
        }
        talgo(node.left, box, i-1, ans);
        talgo(node.right, box, i-1, ans);
    }
}