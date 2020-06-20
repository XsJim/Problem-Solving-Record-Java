public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findSpecialInteger(new int[] {1,2,2,6,6,6,6,7,10}));
    }
}

class Solution {
    public int findSpecialInteger(int[] arr) {
        double brake = arr.length / 4.0;
        for (int i = 0, prev = 0, count = 0; i < arr.length; i++) {
            if (arr[i] != prev) {
                prev = arr[i];
                count = 0;
            }
            if (++count > brake) return prev;
        }
        return -1;
    }
}