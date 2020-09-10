import java.util.List;
import java.util.ArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(new Solution().findMode(root)));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // 二叉搜索树的中序遍历可以将元素按序输出
    // 那么在这个输出位置进行处理比较方便
    // 设一个全局变量 lastNumber ，用来存放最后输出的数字
    // 1. 在遍历完左子树后， lastNumber 中保存的就是在输出序列中，当前数字的前一个数字
    // 再设置一个全局变量 count ，用来存放最后输出数字的出现个数
    // 2. 如果第一步中， 当前数字和 lastNumber 中存放的数字相同，说明这个数字的个数要加一，这时可以判断它是否新的众数
    // 3. 如果不同，那么当前数字就是第一次出现，要将 count 归 1
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midAlgo(root, new int[1], new int[1], new int[] {0}, list, new boolean[] {true});
        int[] ans = new int[list.size()];
        int i = 0;
        for (int x : list) {
            ans[i++] = x;
        }
        return ans;
    }

    private static void midAlgo(TreeNode node, int[] lastNumber, int[] count, int[] max, List<Integer> list, boolean[] flag) {
        if (node == null) return;
        midAlgo(node.left, lastNumber, count, max, list, flag);
        if (flag[0]) {
            lastNumber[0] = node.val;
            count[0] = 1;
            flag[0] = false;
        } else {
            if (lastNumber[0] == node.val) {
                count[0]++;
            } else {
                lastNumber[0] = node.val;
                count[0] = 1;
            }
        }

        if (count[0] > max[0]) {
            list.clear();
            list.add(node.val);
            max[0] = count[0];
        }
        else if (count[0] == max[0]) {
            list.add(node.val);
        }
        midAlgo(node.right, lastNumber, count, max, list, flag);
    }
}