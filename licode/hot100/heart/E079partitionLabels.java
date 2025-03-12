package heart;

import java.util.ArrayList;
import java.util.List;

public class E079partitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        //贪心 需要划分出最多的片段
        int[] map = new int[26]; //保存出现过的字符的最远下标
        char[] chars = s.toCharArray();
        //统计每个字符出现的最远下标位置
        for (int i = 0; i < chars.length; i++) {
           map[chars[i] - 'a'] = i;
        }
        //如果出现的最远下标的位置等于当前位置，说明当前位置前面可以划分出一个片段
        int index = -1;//需要记录长度，所以记录 起始位置的上一个下标
        int max = 0; //记录遍历过的字符中，记录的最远下标位置
        for (int i = 0; i < chars.length; i++) {
            max = Math.max(max,map[chars[i] - 'a']);
            if(max == i){
                //当前下标等于遍历过的字符中，记录的最远下标位置
                //划分片段
                res.add(i-index);
                index = i;
            }
        }
        return res;
    }
}
