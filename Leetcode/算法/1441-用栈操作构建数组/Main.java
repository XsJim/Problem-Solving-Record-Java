import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().buildArray(new int[] {1,3}, 3));
        System.out.println(new Solution().buildArray(new int[] {1,2,3}, 3));
        System.out.println(new Solution().buildArray(new int[] {1,2}, 4));
        System.out.println(new Solution().buildArray(new int[] {2,3,4}, 4));
    }
}

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new LinkedList<>();
        for (int i = 0, j = 1; i < target.length; i++, j++) {
            while (j < target[i]) {
                list.add("Push");
                list.add("Pop");
                j++;
            }
            list.add("Push");
        }
        return list;
    }
}