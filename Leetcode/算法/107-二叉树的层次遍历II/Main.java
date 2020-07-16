import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(new Solution().levelOrderBottom(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        class Node {
            int x;
            int d;
            Node(int x, int d) {
                this.x = x;
                this.d = d;
            }
        }

        Stack<Node> stack = new Stack<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<Integer> qt = new ArrayDeque<>();
        q.add(root); qt.add(0);
        while (q.size() > 0) {
            TreeNode t = q.poll();
            int dd = qt.poll();
            stack.push(new Node(t.val, dd));
            if (t.left != null) {
                q.add(t.left);
                qt.add(dd+1);
            }
            if (t.right != null) {
                q.add(t.right);
                qt.add(dd+1);
            }
        }

        List<List<Integer>> lists = new ArrayList<>();
        while (!stack.empty()) {
            Node n = stack.pop();
            Stack<Integer> stack_2 = new Stack<>();
            
            stack_2.push(n.x);
            while (!stack.empty() && stack.peek().d == n.d) {
                stack_2.push(stack.pop().x);
            }

            List<Integer> list = new ArrayList<>();
            while (!stack_2.empty()) {
                list.add(stack_2.pop());
            }
            
            lists.add(list);
        }
        return lists;
    }
}