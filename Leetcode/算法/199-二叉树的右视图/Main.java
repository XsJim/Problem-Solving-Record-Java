import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(new Solution().rightSideView(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// 层序遍历，取每行最后一个元素
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        
        while (queue.size() > 0) {
            if (queue.size() > 0) ans.add(queue.getLast().val);
            Deque<TreeNode> queue_2 = new ArrayDeque<>();
            TreeNode cur = queue.poll();
            while (cur != null) {
                if (cur.left != null) queue_2.add(cur.left);
                if (cur.right != null) queue_2.add(cur.right);
                cur = queue.poll();
            }

            queue = queue_2;
        }

        return ans;
    }
}