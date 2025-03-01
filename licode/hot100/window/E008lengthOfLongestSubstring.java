package window;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复的最长子串
 */
public class E008lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        //用来存储出现过的字符 键：字符 值：下标
        Map<Character,Integer> map = new HashMap<>();
        int begin = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                //出现重复，修改begin的值，begin不后退
                begin = Math.max(map.get(c)+1,begin);
                //修改map中字符的下标
                map.put(c,i);
            }else {
                map.put(c,i);
            }
            maxLength = Math.max(maxLength,i - begin + 1);
        }
        return maxLength;
    }
}
