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
        System.out.println(new Solution().levelOrder(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // 使用队列来进行层序遍历，将每个结点的子结点依序加入队列中
    // 要处理结果的分层存放，需要设立两个值，一个是上一层的剩余结点数量，一个当前层已加入队列的结点数量
    // 初始时，根结点在队列中，当前层是第二层，已加入队列的结点数量是 len(0) ，上一层的剩余结点数量是 x(1) ，即根节点
    // 循环的条件是队列不为空
    // 首先取出队列头部结点，这时上层结点数量减一 x--
    // 然后将这个结点的数字加入上一层的遍历序列
    // 之后判断该结点的左右结点
    // 当子结点不为空时，就将它加入队列中，并且已加入队列结点数量加一 len++
    // 之后，再判断 x 当前是否为 0 ，如果上一层的结点数量已经为 0 ，说明上一层结点的值都已加入遍历序列
    // 这时，将遍历上一层的遍历序列加入答案序列，并将其重新初始化，以便装入下一层的元素
    // 同时，上一层下移至这一层（上层结点都出队，那么当前这一层的所有结点都已加入队列），那么表示上层剩余结点数量的 x = len
    // 表示当前层结点数量（已加入队列结点数量） len 归 0
    // 当队列为空，所有层都已加入答案序列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> current = new ArrayList<>();
        int x = 1, len = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode current_node = queue.poll();
            x--;
            current.add(current_node.val);
            if (current_node.left != null) {
                queue.add(current_node.left);
                len++;
            }
            if (current_node.right != null) {
                queue.add(current_node.right);
                len++;
            }
            if (x == 0) {
                ans.add(current);
                current = new ArrayList<>();
                x = len;
                len = 0;
            }
        }
        return ans;
    }
}