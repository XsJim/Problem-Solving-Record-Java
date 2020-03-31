# Leetcode-程序员面试金典-栈排序

## 题目

原题
> 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。

示例 1
> 输入：
> `["SortedStack", "push", "push", "peek", "pop", "peek"]`
> `[[], [1], [2], [], [], []]`
> 输出：
> `[null,null,null,1,null,2]`

示例 2
> 输入：
> `["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]`
> `[[], [], [], [1], [], []]`
> 输出：
> `[null,null,null,null,null,true]`

说明
>
> 1. 栈中的元素数目在 `[0, 5000]` 范围内。

## 题目分析

为了实现最小元素位于栈顶，每次添加新元素时就要对整个栈（ `stack` ）进行排序。

设想 `stack` 已经排序，最小元素位于栈顶，要将新添加的元素（ `val` ）置于 `stack` 中正确的位置。

`val` 要处于已排序序列中合适的位置，使 `stack` 依然有序，如何做到这一点？我们需要将 `stack` 内的元素一一取出与 val 比较，来判断 `val` 该放在哪个位置。

当前， `stack` 是有序的，最小元素位于栈顶，如果 `val` 小于或等于栈顶元素，那么它也小于或等于 `stack` 内其他元素，这种情况 `val` 直接入 `stack` 。

如果 `val` 大于栈顶元素，说明新的栈顶位置不是最适合 `val` 的位置，这时就要比较 `stack` 的下一个元素，所以需要把 `stack` 顶的元素取出，取出的元素得有暂存的位置，设置辅助栈（ `stack_buffer` ）来进行。

从 `stack` 取出的元素按取出顺序放入 `stack_buffer` ，那么 `stack_buffer` 就成了一个有序的且最大值处于栈顶的栈。

当 `stack` 的栈顶元素大于或等于 `val` 时，说明已经到达最适位置，即 `stack` 内元素小于等于 `val` 且有序， `stack_buffer` 内元素大于 `val` 且有序。

当 `stack` 为空时，同样表示 `val` 到达最适位置，所以以上过程也适用于初始无元素时向 `stack` 添加元素。

## 流程

`void push(int val)` 部分

`while:` stack 不空且栈顶元素小于 val
`do:` 将栈顶元素弹出并压入 stack_buffer
将 val 压入 stack
`while:` stack_buffer 不空
`do:` 将栈顶元素弹出并压入 stack

## 代码

```java
class SortedStack {
    private ArrayDeque<Integer> stack;
    private static ArrayDeque<Integer> stack_buffer = new ArrayDeque<>();

    public SortedStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        while (!stack.isEmpty() && val > stack.getFirst()) {
            stack_buffer.push(stack.pop());
        }
        stack.push(val);
        while (!stack_buffer.isEmpty()) {
            stack.push(stack_buffer.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) stack.pop();
    }

    public int peek() {
        if (!stack.isEmpty()) return stack.getFirst();
        else return -1;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
```
