public class Main {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});

        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}

class NumArray {
    private int[] ans;
    
    public NumArray(int[] nums) {
        if (nums.length != 0) {
            ans = new int[nums.length+1];
            for (int i = 0; i < nums.length; i++) {
                ans[i+1] = ans[i] + nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        return ans[j+1] - ans[i];
    }
}