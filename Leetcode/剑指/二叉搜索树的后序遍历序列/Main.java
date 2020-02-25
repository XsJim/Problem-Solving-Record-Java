public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().verifyPostorder(new int[] {1,6,3,2,5}));
        System.out.println(new Solution().verifyPostorder(new int[] {7,8,9,10,5}));
    }
}

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return talgo(postorder, 0, postorder.length-1);
    }

    private static boolean talgo(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int z = 0;
        for (int h = i; h < j; h++) {
            if (postorder[h] < postorder[j]) z++;
        }
        for (int h = i + z; h < j; h++) {
            if (postorder[h] < postorder[j]) return false;
        }
        return talgo(postorder, i, i+z-1) && talgo(postorder, i+z, j-1);
    }
}