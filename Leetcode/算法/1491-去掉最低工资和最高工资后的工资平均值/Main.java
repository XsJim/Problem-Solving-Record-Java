public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().average(new int[] {4000,3000,1000,2000}));
        System.out.println(new Solution().average(new int[] {1000,2000,3000}));
        System.out.println(new Solution().average(new int[] {6000,5000,4000,3000,2000,1000}));
        System.out.println(new Solution().average(new int[] {8000,9000,2000,3000,6000,1000}));
    }
}

class Solution {
    public double average(int[] salary) {
        double sum = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            if (salary[i] > max) max = salary[i];
            if (salary[i] < min) min = salary[i];
        }

        return (sum - max - min) / (salary.length - 2);
    }
}