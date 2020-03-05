public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().sumNums(10000));
        System.out.println(new Solution().sumNums(3));
        System.out.println(new Solution().sumNums(9));
    }
}

class Solution {
    public int sumNums(int n) {
        return n*(1+n)/2;
    }
}