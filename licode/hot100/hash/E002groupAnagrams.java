package hash;

import java.util.*;

/**
 * 字母异位词
 * 由重新排列源单词的所有字母得到的一个新单词
 */
public class E002groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //键：排序后的单词 值：单词
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a','d','o','w','c'};
        Arrays.sort(chars);
        for (char c : chars) {
            System.out.println(c);
        }
    }
}
