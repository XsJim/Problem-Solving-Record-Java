import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        List<List<String>> favoriteCompanies = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("leetcode");
        list.add("google");
        list.add("facebook");
        favoriteCompanies.add(list);
        list = new ArrayList<>();
        list.add("google");
        list.add("microsoft");
        favoriteCompanies.add(list);
        list = new ArrayList<>();
        list.add("google");
        list.add("facebook");
        favoriteCompanies.add(list);
        list = new ArrayList<>();
        list.add("google");
        favoriteCompanies.add(list);
        list = new ArrayList<>();
        list.add("amazon");
        favoriteCompanies.add(list);
        System.out.println(new Solution().peopleIndexes(favoriteCompanies));
    }
}

class Solution {
    // 遍历清单，让每个清单作为对象，确定其他清单是否是它的子集
    // 确定一个清单是否是子集前，要确定这个要判断的清单的长度小于或等于要比较的清单（外部循环的清单）
    // 还要确定它不是其他清单的子集，如果这个清单已经确定是一个子集，就没有必要再次进行对比
    // 最终遍历标记清单检查每个清单是否是其它清单的子集，把不是任何清单子集的清单下标加入答案链表即可
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int i = 0;
        boolean[] isSubset = new boolean[favoriteCompanies.size()];
        for (List<String> list : favoriteCompanies) {
            int j = -1;
            Map<String, Boolean> listMap = new HashMap<>();
            for (String s : list) {
                listMap.put(s, true);
            }
            for (List<String> listCurrent : favoriteCompanies) {
                j++;
                if (i == j || listCurrent.size() > list.size() || isSubset[j]) continue;
                boolean flag = true;
                for (String s : listCurrent) {
                    if (listMap.get(s) == null) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    isSubset[j] = true;
                }
            }
            i++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int z = 0; z < isSubset.length; z++) {
            if (!isSubset[z]) ans.add(z);
        }

        return ans;
    }
}