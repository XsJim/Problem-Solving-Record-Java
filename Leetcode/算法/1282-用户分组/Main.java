import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().groupThePeople(new int[] {3,3,3,3,3,1,3});
        for (List<Integer> list : lists) {
            for (int i : list) System.out.print(i+" ");
            System.out.println();
        }
        System.out.println("---------------");
        lists = new Solution().groupThePeople(new int[] {2,1,3,3,3,2});
        for (List<Integer> list : lists) {
            for (int i : list) System.out.print(i+" ");
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        ArrayList<List<Integer>> arr = new ArrayList<>(501);
        for (int i = 0; i < 501; i++) {
            arr.add(new LinkedList<>());
        }
        int max = 0;
        for (int i = 0; i < groupSizes.length; i++) {
            arr.get(groupSizes[i]).add(i);
            if (groupSizes[i] > max) max = groupSizes[i];
        }
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 1; i <= max; i++) {
            List<Integer> list = arr.get(i);
            List<Integer> inAns = new LinkedList<>();
            int j = 0;
            for (int x : list) {
                inAns.add(x);
                j++;
                if (j == i) {
                    j = 0;
                    ans.add(inAns);
                    inAns = new LinkedList<>();
                }
            }
        }
        return ans;
    }
}