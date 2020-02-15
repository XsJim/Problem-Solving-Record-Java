public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minArray(new int[] {3,4,5,1,2}));
        System.out.println(new Solution().minArray(new int[] {2,2,0,0,1}));
        System.out.println(new Solution().minArray(new int[] {1}));
    }
}

class Solution {
    public int minArray(int[] numbers) {
        int i = 0, tmin = 0;
        while (i < numbers.length) {
            if (numbers[i] < numbers[tmin]) {
                tmin = i;
                break;
            }
            i++;
        }
        return numbers[tmin];
    }
}