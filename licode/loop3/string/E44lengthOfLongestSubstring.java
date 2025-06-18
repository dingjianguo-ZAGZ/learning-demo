package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E44lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < chars.length; r++) {
            if (map.containsKey(chars[r])) {
                //l移动到重复字符的下一位
                l = Math.max(l, map.get(chars[r]) + 1);
                //更新重复字符下标
            }
            map.put(chars[r], r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
