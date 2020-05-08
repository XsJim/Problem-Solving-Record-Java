public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().game(new int[] {1,2,3}, new int[] {1,2,3}));
        System.out.println(new Solution().game(new int[] {2,2,3}, new int[] {3,2,1}));
    }
}

class Solution {
    public int game(int[] guess, int[] answer) {
        int sum = 0;
        for (int i = 0; i < 3; i++) if (guess[i] == answer[i]) sum++;
        return sum;
    }
}