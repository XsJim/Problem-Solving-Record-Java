import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findRestaurant(new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[] {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
        System.out.println(Arrays.toString(new Solution().findRestaurant(new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[] {"KFC", "Shogun", "Burger King"})));
    }
}

class Solution {
    // 创建散列表，键为字符串，值为字符串的下标
    // 遍历第一个数组，将字符串和它们的下标映射到散列表
    // 遍历第二个数组，在散列表中查找当前字符串并得到下标
    // 如果值为 null 说明两个数组不同时存在这个字符串
    // 否则将这个下标和当前下标相加，判断它的值是否比当前最小值小
    // 如果小于，则将当前答案链表清空，再将当前字符串添加到答案
    // 如果等于，则直接将当前字符串添加
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            Integer index = map.get(list2[i]);
            if (index != null) {
                int x = index + i;
                if (x < min) {
                    ans.clear();
                    ans.add(list2[i]);
                    min = x;
                }
                else if (x == min) {
                    ans.add(list2[i]);
                }
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}