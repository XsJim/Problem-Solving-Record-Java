public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxAliveYear(new int[] {1900, 1901, 1950}, new int[] {1948, 1951, 2000}));
    }
}

class Solution {
    public int maxAliveYear(int[] birth, int[] death) {
        int min_birth = 2000, max_death = 1900;
        int n = birth.length;
        for (int i = 0; i < n; i++) {
            if (birth[i] < min_birth) min_birth = birth[i];
            if (death[i] > max_death) max_death = death[i];
        }
        int m = max_death - min_birth + 1;
        int[] arr = new int[m];
        for (int i = 0; i < n; i++) {
            int the_death = death[i] - min_birth;
            for (int j = birth[i] - min_birth; j <= the_death; j++) {
                arr[j]++;
            }
        }
        int max = 0, max_year = -1;
        for (int i = 0; i < m; i++) {
            if (arr[i] > max) {
                max = arr[i];
                max_year = i + min_birth;
            }
        }
        return max_year;
    }
}