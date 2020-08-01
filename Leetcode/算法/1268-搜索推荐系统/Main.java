import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
        System.out.println(new Solution().suggestedProducts(new String[] {"havana"}, "havana"));
        System.out.println(new Solution().suggestedProducts(new String[] {"bags","baggage","banner","box","cloths"}, "bags"));
        System.out.println(new Solution().suggestedProducts(new String[] {"havana"}, "tatiana"));
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        int index = 0;
        char x = searchWord.charAt(index);
        for (int i = 0; i < products.length; i++) {
            if (products[i].charAt(index) == x) {
                pq.add(products[i]);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        while (pq.size() > 0) temp.add(pq.poll());
        while (index < searchWord.length()) {
            List<String> list = new ArrayList<>();
            List<String> temp_2 = new ArrayList<>();
            int count = 0; x = searchWord.charAt(index);
            for (String s : temp) {
                if (index < s.length() && s.charAt(index) == x) {
                    if (count != 3) {
                        list.add(s);    
                        count++;
                    }
                    temp_2.add(s);
                }
            }
            ans.add(list);
            temp = temp_2;
            index++;
        }

        return ans;
    }
}