import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// 进行一般的二叉树层次遍历，在其中加入一个标记
// 根据标记的不同，向栈中添加结点的顺序也不同，分为左右、右左两种情况
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> dq = new ArrayDeque<>();

        dq.push(root);
        boolean flag = false;
        while (dq.size() > 0) {
            Deque<TreeNode> dqc = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            while (dq.size() > 0) {
                TreeNode cur = dq.pop();
                list.add(cur.val);
                if (flag) {
                    if (cur.right != null) dqc.push(cur.right);
                    if (cur.left != null) dqc.push(cur.left);
                } else {
                    if (cur.left != null) dqc.push(cur.left);
                    if (cur.right != null) dqc.push(cur.right);
                }
            }
            ans.add(list);
            flag = !flag;
            dq = dqc;
        }

        return ans;
    }
}