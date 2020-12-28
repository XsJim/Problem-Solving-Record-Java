import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(new Solution().largestValues(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
// 递归每个结点，在递归中，加入一个记录当前层数的变量
// 如果当前答案储存数列中，对应的层数已经有数字，就和当前结点的值进行对比，放入较大的值
// 否则，将新的值添加到链表末尾
// 因为递归是从树的顶端依次到树的底端，如果对应层数在链表中还没有记录，直接添加到链表末尾，将和当前层数对应
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        talgo(root, ans, 1);
        return ans;
    }

    private static void talgo(TreeNode node, List<Integer> ans, int h) {
        if (node == null) return;
        if (ans.size() < h) {
            ans.add(node.val);
        } else {
            int x = ans.get(h-1);
            if (node.val > x) {
                ans.set(h-1, node.val);
            }
        }
        talgo(node.left, ans, h+1);
        talgo(node.right, ans, h+1);
    }
}