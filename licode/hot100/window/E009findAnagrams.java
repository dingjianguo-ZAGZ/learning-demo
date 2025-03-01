package window;

import java.beans.BeanInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 */
public class E009findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if(sLen < pLen){
            return new ArrayList<>();
        }
        //定义结果集
        List<Integer> res = new ArrayList<>();
        //定义int数组，维护字符串中字符的数量
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        //特殊情况，s无法构造与 p 等长的字符串
        for (int i = 0; i < pLen; i++) {
            ++pCount[p.charAt(i) - 'a'];
            ++sCount[s.charAt(i) - 'a'];
        }
        if(Arrays.equals(sCount,pCount)){
            res.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            //维护滑动窗口的大小等于 p 字符串的长度
            //去掉前一个字符
            --sCount[s.charAt(i) - 'a'];
            //加入后一个字符
            ++sCount[s.charAt(i+pLen) - 'a'];
            //判断是否相同
            if(Arrays.equals(pCount,sCount)){
                res.add(i + 1);
            }
        }
        return res;
    }
}
