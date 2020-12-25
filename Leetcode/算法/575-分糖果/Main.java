import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().distributeCandies(new int[] {1,1,2,2,3,3}));
        System.out.println(new Solution().distributeCandies(new int[] {1,1,2,3}));
    }
}

// 首先，遍历给定数组，计数不同种类糖果数量，保存在count中
// 然后，判断count和糖果总数一半half的大小关系
// 如果：count >= half 说明糖果种类大于糖果总数量的一半，那么此时就算每种糖果只分给妹妹一块，妹妹最多也只能得到half数量的不同种类糖果
// 否则：糖果总类小于糖果总数的一半，此时最优的办法，就是每种糖果至少分给妹妹一个，那么妹妹就可以得到所有种类的糖果
class Solution {
    public int distributeCandies(int[] candyType) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < candyType.length; i++) {
            if (map.get(candyType[i]) == null) {
                map.put(candyType[i], 0);
                count++;
            }
        }

        int ans = 0;
        int half = candyType.length / 2;
        if (count >= half) return half;
        return count;
    }
}