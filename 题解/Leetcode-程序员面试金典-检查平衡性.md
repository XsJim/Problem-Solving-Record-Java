# Leetcode-程序员面试金典-检查平衡性

## 题目

原题
> 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。

示例 1
> 输入：
> `[3,9,20,null,null,15,7]`
> 输出：
> `true`

示例 2
> 输入：
> `[1,2,2,3,3,null,null,4,4]`
> 输出：
> `false`

## 题目分析

首先，一棵树的高度是当前节点左右子数中高度较大的一个加 1 得到

当一个节点的左右子树高度差相差超过 1 时，便说这棵树不平衡了

直观的计算方法很简单，遍历每个节点，计算它的左右子树高度，然后看看相差是否比 1 大

从顶到底遍历时，存在重复计算同一树枝的高度的冗余

而从底到顶遍历时，可以避免重复计算同一树枝的高度，而且可以在某一处发现错误时，马上结束并返回结果

## 代码

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (talgo(root) < 0) return false;
        return true;
    }

    private static int talgo(TreeNode node) {
        if (node == null) return 0;
        int left = talgo(node.left);
        if (left < 0) return -1;
        int right = talgo(node.right);
        if (right < 0) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
```
