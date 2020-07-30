import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new Solution().preorderTraversal(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode current = root;
        while (current != null) {
            while (current != null) {
                stack.push(current);
                list.add(current.val);
                current = current.left;
            }
            while (!stack.empty()) {
                current = stack.pop().right;
                if (current != null) break;
            }
        }

        return list;
    }
}