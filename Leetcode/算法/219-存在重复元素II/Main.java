import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyDuplicate(new int[] {1,2,3,1}, 3));
        System.out.println(new Solution().containsNearbyDuplicate(new int[] {1,0,1,1}, 1));
        System.out.println(new Solution().containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2));
    }
}

// 建立散列表，键为数字实体，值为该实体在数组中最近出现位置下标
// 遍历数组，如果当前位置数字没有出现在散列表中，则将其添加
// 否则，得到该实体上次最近出现位置下标，与当前位置做差并得到绝对值
// 判断这个绝对值是否小于等于k
// 若是，则返回true
// 若否，则将实体最近出现下标更新，继续遍历
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer x = map.get(nums[i]);
            if (x != null) {
                if (Math.abs(x - i) <= k) return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}