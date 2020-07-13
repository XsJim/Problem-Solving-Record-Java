import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortByBits(new int[] {0,1,2,3,4,5,6,7,8})));
        System.out.println(Arrays.toString(new Solution().sortByBits(new int[] {1024,512,256,128,64,32,16,8,4,2,1})));
        System.out.println(Arrays.toString(new Solution().sortByBits(new int[] {10000,10000})));
        System.out.println(Arrays.toString(new Solution().sortByBits(new int[] {2,3,5,7,11,13,17,19})));
        System.out.println(Arrays.toString(new Solution().sortByBits(new int[] {10,100,1000,10000})));
    }
}

class Solution {
    public int[] sortByBits(int[] arr) {
        class Node {
            int x;
            int count_b;
            Node(int x) {
                this.x = x;
                count_b = 0;
                while (x != 0) {
                    if ((x & 1) == 1) count_b++;
                    x >>= 1;
                }
            }
        }

        Node[] ns = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) ns[i] = new Node(arr[i]);

        Arrays.sort(ns, (a, b) -> {
            if (a.count_b != b.count_b) return Integer.compare(a.count_b, b.count_b);
            return Integer.compare(a.x, b.x);
        });

        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) ans[i] = ns[i].x;

        return ans;
    }
}