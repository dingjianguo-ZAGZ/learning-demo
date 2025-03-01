package hash;

import javax.swing.plaf.basic.BasicEditorPaneUI;
import java.util.Arrays;
import java.util.HashMap;

public class E09lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        /*//滑动窗口
        //使用map数组的 键 存储字符,值 存储 在字符串中的位置，这样方便找到每一个字符的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if(!map.containsKey(c)){
                //没有重复
                map.put(c,r);
            }else{
                //重复
                //将 l 指针指向重复字符的下一个字符
                //map的值存储了重复字符在字符串中的位置
                int re = map.get(c);
                //如果重复字符的下一个位置小于 l,l 不变，因为说明l 到 re+1之间存在其他重复字符
                l = Math.max(l,re+1);
                //修改重复字符的位置
                map.put(c,r);
            }
            res = Math.max(res,r-l+1);
        }
        return res;*/


        //滑动窗口，受用int数组存储 字符的位置
        int[] map = new int[128];
        //将所有字符的位置都添成-1（如果存在该字符，下标不可能时-1）
        Arrays.fill(map,-1);
        int l = 0;
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if(map[c] == -1){
                //不存在该字符,设置下标
                map[c] = r;
            }else {
                //存在
                l = Math.max(l,map[c]+1);
                map[c] = r;
            }
            res = Math.max(res,r - l + 1);
        }
        return res;
    }


}
