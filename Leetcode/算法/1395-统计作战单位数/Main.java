public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numTeams(new int[] {2,5,3,4,1}));
        System.out.println(new Solution().numTeams(new int[] {2,1,3}));
        System.out.println(new Solution().numTeams(new int[] {1,2,3,4}));
    }
}

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[j] > rating[i]) a[i]++;
                else if (rating[j] < rating[i]) b[i]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[j] > rating[i]) sum += a[j];
                else if (rating[j] < rating[i]) sum += b[j];
            }
        }
        return sum;
    }
}