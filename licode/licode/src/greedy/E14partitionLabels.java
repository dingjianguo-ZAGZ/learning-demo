package greedy;

import java.util.ArrayList;
import java.util.List;

public class E14partitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26];//用来保存每个字符出现的最远下标
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //统计每个字符最后出现的位置
            char c = chars[i];
            map[c - 'a'] = i;
        }
        int max = 0;//当前片段字符出现的最远位置
        int start = -1;//每个片段起始位置 - 1
        //如果最远出现位置等于当前位置，截断
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            max = Math.max(max,map[c - 'a']);
            if(i == max){
                res.add(i - start);
                start = i;
            }
        }
        return res;
    }
}
