import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minNumber(new int[] {10,2}));
        System.out.println(new Solution().minNumber(new int[] {3,30,34,5,9}));
    }
}

class Solution {
    public String minNumber(int[] nums) {
        int tlength = nums.length;
        String[] strings = new String[tlength];
        for (int i = 0; i < tlength; i++) {
            strings[i] = Integer.valueOf(nums[i]).toString();
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}