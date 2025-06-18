package hash;

import java.util.HashMap;
import java.util.Map;


public class E37lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        //双指针
        char[] chars = s.toCharArray();
        int l = 0;
        Map<Character,Integer> map = new HashMap<>(); //保存重复数字，和重复数字的下标
        int res = 0;
        for (int r = 0; r < chars.length; r++) {
            if (map.containsKey(chars[r])) {
                //出现重复，移动左指针
                l = Math.max(l,map.get(chars[r])+1); //如果重复字符出现的位置在左指针左边，左指针不懂，减少从map中移除元素
                //修改重复字符的下标
                map.put(chars[r],r);
            }else {
                map.put(chars[r],r);
            }
            res = Math.max(res,r - l + 1);
        }
        return res;
    }
}
