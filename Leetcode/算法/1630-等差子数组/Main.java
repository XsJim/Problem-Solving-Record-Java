import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().checkArithmeticSubarrays(new int[] {4,6,5,9,3,7}, new int[] {0,0,2}, new int[] {2,3,5}));
        System.out.println(new Solution().checkArithmeticSubarrays(new int[] {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, new int[] {0,1,6,4,8,7}, new int[] {4,4,9,7,9,10}));
    }
}


// 循环每个区间，并且将每个区间的值依次加入优先队列中（红黑树）
// 每个区间加入之后，依序判断它们的差值是否相同
// 然后将结果加入答案
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int j = l[i]; j <= r[i]; j++) {
                pq.add(nums[j]);
            }
            int prev = pq.poll();
            int current = pq.poll();
            int dc = prev - current;
            boolean flag = true;
            while (pq.size() > 0) {
                prev = current;
                current = pq.poll();
                if ((prev - current) != dc) {
                    flag = false;
                    break;
                }
            }
            ans.add(flag);
        }

        return ans;
    }
}