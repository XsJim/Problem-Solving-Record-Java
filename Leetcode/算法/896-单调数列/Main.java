public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isMonotonic(new int[] {1,2,2,3}));
        System.out.println(new Solution().isMonotonic(new int[] {6,5,4,4}));
        System.out.println(new Solution().isMonotonic(new int[] {1,3,2}));
        System.out.println(new Solution().isMonotonic(new int[] {1,2,4,5}));
        System.out.println(new Solution().isMonotonic(new int[] {1,1,1}));
    }
}

class Solution {
    // 如果数组只有一个数，那么该数组是单调的
    // 否则，随意抽取数组中相邻的两个数，如果不能保证每组的单调性都一致，则该数组不是单调的
    // 抽取出的两个相邻的数，有三种关系，大于、等于、小于
    // 其中，等于不影响单调性，也就是说，要忽略所有相等的组
    // 其次，单调性一但确定，之后抽取的所有组都需要满足这一单调性，整个数组才是单调的
    // 所以设置一个标记，用来标记数组的单调性，初始化为 0 ，表示单调性未确定
    // 标记还有两种状态： 1 代表单调递减， -1 代表单调递增
    // 接下来是检测的步骤，根据这样的一个事实：有三个数排成一排，如果第一个数小于第二个数，第二个数小于第三个数，那么第一个数也一定小于第三个数
    // 我们只需检测每对相邻元素的单调性是否一致，便可确定整个数组是否单调
    // 如果当前的一对相等，则不影响结果，直接跳过
    // 如果当前的一对不等，这时需要先查看标记的状态：
    // 1. 如果标记为 0 ，则将标记的状态改变为当前一对的单调性
    // 2. 如果标记不为 0 ，则判断标记的状态是否与当前一对的单调性相同，不同则说明整个数组不单调

    public boolean isMonotonic(int[] A) {
        if (A.length == 1) return true;
        int i = 0, j = 1;
        int flag = 0;
        while (j < A.length) {
            if (A[i] != A[j]) {
                if (flag == 1) {
                    if (A[i] < A[j]) return false;
                }
                else if (flag == -1) {
                    if (A[i] > A[j]) return false;
                } else {
                    flag = A[i] < A[j] ? -1 : 1;
                }
            }
            i = j;
            j++;
        }

        return true;
    }
}