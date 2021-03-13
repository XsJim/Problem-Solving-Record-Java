public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findMinFibonacciNumbers(7));
        System.out.println(new Solution().findMinFibonacciNumbers(10));
        System.out.println(new Solution().findMinFibonacciNumbers(19));
    }
}

// 1. 如果给定的数是一个斐波那契数，那么只需 1 个斐波那契数即可得到（它自己）
// 2. 如果不是，通过观察，得到一种组合方式（贪心）：
//   1. 在斐波那契数列中，找到最接近当前所求数 x ，小于 x 的斐波那契数 y
//   2. 将 x 更新为 x - y （还需要多少）
//   3. 重复第 1 步，直到 x 为 0
// 3. 由于数字可重复使用，一个数可以由多种组合得到，依然是通过观察，得出：
//   由贪心方式得出的组合内的数字个数，总是一个最小值（不论如何选择，数字个数不可能低于这个数）
// 4. 第 2 条给出计算方法，第 3 条确定了计算方法的正确性，这个方法的详细步骤如下：
//   1. 首先需要一个斐波那契数列，题目给定的最大可能求值为 10^9 ，那么所需要的最大斐波那契数不需要超过此值，通过计算（枚举）得到我们查找所需的斐波那契数的总数为 44 （从 1 开始）
//   2. 得到查找所需的斐波那契数列，下一步便是查找，为了加快查找速度，采用二分查找，这个二分查找需要返回最接近（小于等于）给定查找值的值的下标
//   3. 由第二条给出的计算方法，在得到这个最接近值后，需要将所求值更新，新值为原查找值减去最接近值
//   4. 重复第 2, 3 步，直到新值为 0 ，那么所求的需要的步骤数就是总的查找数（每查找一次，就意味着需要添加一个数到最终组合中）
class Solution {
    public int findMinFibonacciNumbers(int k) {
        int arrLen = 44;
        int[] arr = new int[arrLen];
        fill(arr);

        int num = 0;
        int sum = 0;
        int l = 0, r = arrLen - 1;
        int key = k;
        while (sum != k) {
            int close = binarySearch(l, r, arr, key);
            sum += arr[close];
            key -= arr[close];
            num++;
            r = close - 1;
        }
        
        return num;
    }

    private static int binarySearch(int l, int r, int[] arr, int key) {
        int closeM = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] > key) {
                r = m - 1;
            }
            else if (arr[m] < key) {
                closeM = m;
                l = m + 1;
            } else {
                closeM = m;
                break;
            }
        }
        return closeM;
    }

    private static void fill(int[] arr) {
        long a = 1, b = 1;
        long c = a + b;

        arr[0] = 1; arr[1] = 1;

        int i = 2;
        while (c <= 1e9) {
            arr[i++] = (int)c;
            a = b;
            b = c;
            c = a + b;
        }
    }
}