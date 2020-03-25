public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findString(new String[] {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""}, "ta"));
        System.out.println(new Solution().findString(new String[] {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""}, "ball"));
    }
}

class Solution {
    public int findString(String[] words, String s) {
        if (s == null || words == null) return -1;
        return binarySearch(words, s, 0, words.length-1);
    }

    private static int binarySearch(String[] words, String s, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (words[mid].equals("")) {
                int a = binarySearch(words, s, left, mid-1);
                int b = binarySearch(words, s, mid+1, right);
                return a > b ? a : b;
            }

            int cmp = words[mid].compareTo(s);
            if (cmp > 0) right = mid - 1;
            else if (cmp < 0) left = mid + 1;
            else return mid;
        }
        return -1;
    }
}