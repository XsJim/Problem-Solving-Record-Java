public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().divisorGame(1));
        System.out.println(new Solution().divisorGame(2));
        System.out.println(new Solution().divisorGame(3));
    }
}

// 找规律
class Solution {
    public boolean divisorGame(int N) {
        return (N & 1) == 0;
    }
}