import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E013totalFruit {
    public int totalFruit(int[] fruits) {
        //滑动窗口
        int l = 0;
        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        for (int r = 0; r < fruits.length; r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if(map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            res = Math.max(res,r - l + 1);
        }
        return res;
    }
}
