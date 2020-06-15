public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countLargestGroup(13));
        System.out.println(new Solution().countLargestGroup(2));
        System.out.println(new Solution().countLargestGroup(15));
        System.out.println(new Solution().countLargestGroup(24));
    }
}

class Solution {
    public int countLargestGroup(int n) {
        int R = 37;
        int[] count = new int[R];
        for (int i = 1; i <= n; i++) count[bitAdd(i)]++;
        
        int max = 0, sum = 0;
        for (int i = 0; i < R; i++) {
            if (count[i] == max) sum++;
            else if (count[i] > max) {
                max = count[i];
                sum = 1;
            }
        }
        return sum;
    }

    private static int bitAdd(int x) {
        int sum = 0;
        while  (x > 0) {
            sum += (x % 10);
            x /= 10;
        }
        return sum;
    }
}