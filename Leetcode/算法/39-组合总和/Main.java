import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[] {2,3,6,7}, 7));
        System.out.println(new Solution().combinationSum(new int[] {2,3,5}, 8));
    }
}


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            talgo(lists, list, candidates, target, candidates[i]);
            list.removeLast();
        }
        return lists;
    }

    private static void talgo(List<List<Integer>> lists, LinkedList<Integer> list, int[] candidates, int target, int sum) {
        if (sum > target) return;
        if (sum == target) {
            lists.add(new LinkedList<Integer>(list));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] >= list.getLast()) {
                list.add(candidates[i]);
                talgo(lists, list, candidates, target, sum+candidates[i]);
                list.removeLast();
            }
        }
    }
}