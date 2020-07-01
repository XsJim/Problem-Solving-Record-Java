public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(new int[] {5,5,5,10,20}));
        System.out.println(new Solution().lemonadeChange(new int[] {5,5,10}));
        System.out.println(new Solution().lemonadeChange(new int[] {10,10}));
        System.out.println(new Solution().lemonadeChange(new int[] {5,5,10,10,20}));
        System.out.println(new Solution().lemonadeChange(new int[] {5,5,5,10,5,5,10,20,20,20}));
    }
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        return talgo(0, 0, bills, 0);
    }

    private static boolean talgo(int a, int b, int[] bills, int i) {
        if (i == bills.length) return true;
        switch (bills[i++]) {
            case 5:
                a++;
                return talgo(a, b, bills, i);
            case 10:
                if (a > 0) {
                    return talgo(a-1, b+1, bills, i);
                } else return false;
            case 20:
                boolean re = false;
                if (a > 2) {
                    re = talgo(a-3, b, bills, i);
                }
                if (!re && a > 0 && b > 0) {
                    re = talgo(a-1, b-1, bills, i);
                }
                return re;
            default: break;
        }
        return false;
    }
}