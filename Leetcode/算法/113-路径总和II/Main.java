import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(new Solution().pathSum(root, 22));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// 依然是遍历每条可能路径，不同的是在将一个值加入当前和后，要将这个数字加入到一个表示当前所有数字的序列中
// 之后，判断当前和是否和要求和相同，若相同，则将当前序列加入最终答案中，在递归的末尾，要将本轮添加的数字从当前序列中删除
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        talgo(root, sum, 0, new ArrayList<Integer>(), ans);

        return ans;
    }

    private static void talgo(TreeNode node, int sum, int curSum, List<Integer> list, List<List<Integer>> ans) {
        if (node == null) return;
        curSum += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == curSum) {
                List<Integer> listCopy = new ArrayList<>(list);
                ans.add(listCopy);
            }
            list.remove(list.size()-1);
            return;
        }
        talgo(node.left, sum, curSum, list, ans);
        talgo(node.right, sum, curSum, list, ans);
        list.remove(list.size()-1);
    }
}