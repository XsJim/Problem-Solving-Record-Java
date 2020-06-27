import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

import java.util.List;
import java.util.ArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[] {1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[] {1}, 1)));
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        TreeMap<Integer, List<Integer>> map_2 = new TreeMap<>();

        for (Map.Entry <Integer, Integer> me : map.entrySet()) {
            List<Integer> list = map_2.get(me.getValue());
            if (list == null) {
                list = new ArrayList<>();
                map_2.put(me.getValue(), list);
            }
            list.add(me.getKey());
        }

        int[] ans = new int[k];

        while (k > 0) {
            for (int x : map_2.pollLastEntry().getValue()) {
                ans[--k] = x;
            }
        }

        return ans;
    }
}