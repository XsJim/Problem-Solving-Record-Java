import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().deckRevealedIncreasing(new int[] {17,13,11,2,3,5,7})));
    }
}

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] flag = new int[deck.length];
        for (int i = 0; i < deck.length; i++) flag[i] = i;
        for (int i = 1; i < deck.length; i++) {
            int x = flag[i];
            for (int j = i + 1; j < deck.length; j++) {
                flag[j-1] = flag[j];
            }
            flag[deck.length-1] = x;
        }
        int[] ans = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            ans[flag[i]] = deck[i];
        }
        return ans;
    }
}