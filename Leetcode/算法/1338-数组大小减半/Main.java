import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minSetSize(new int[] {3,3,3,3,5,5,5,2,2,7}));
        System.out.println(new Solution().minSetSize(new int[] {7,7,7,7,7,7}));
        System.out.println(new Solution().minSetSize(new int[] {1,9}));
        System.out.println(new Solution().minSetSize(new int[] {1000,1000,3,7}));
        System.out.println(new Solution().minSetSize(new int[] {1,2,3,4,5,6,7,8,9,10}));
    }
}

class Solution {
    public int minSetSize(int[] arr) {
        int len = 100001; int brake = arr.length / 2;
        int[] count = new int[len];
        for (int x : arr) {
            if (++count[x] == brake) return 1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (e, h) -> {
                if (e < h) return 1;
                if (e > h) return -1;
                return 0;
            }
        );

        for (int i = 0, j = 0; i < len; i++) {
            if (count[i] != 0) {
                pq.add(count[i]);
                j += count[i];
                if (j == arr.length) break;
            }
        }
        
        int sum = 0, ans = 0;
        while (true) {
            sum += pq.poll();
            ans++;
            if (sum >= brake) break;
        }
        return ans;
    }
}