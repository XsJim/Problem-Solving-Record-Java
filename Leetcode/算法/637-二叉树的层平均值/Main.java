import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new Solution().averageOfLevels(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        double[] sum = new double[1000];
        int[] count = new int[1000];
        talgo(root, 0, sum, count);
        int i = 0;
        List<Double> ans = new ArrayList<>();
        while (i < 1000 && count[i] > 0) {
            ans.add(sum[i]/count[i]);
            i++;
        }
        return ans;
    }

    private static void talgo(TreeNode node, int h, double[] sum, int[] count) {
        if (node == null) return;
        sum[h] += node.val;
        count[h]++;
        talgo(node.left, h+1, sum, count);
        talgo(node.right, h+1, sum, count);
    }
}