package hash;

import java.util.*;

/**
 * 最长连续序列
 */
public class E003longestConsecutive {
    public int longestConsecutive(int[] nums) {
        //结果
        int longestStreak = 0;
        //对数组元素去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //判断每个数字是否为开头数字
        for (int num : set) {
            //包含当前数字的前一个数字，当前数字不是开头，跳过
            if(!set.contains(num-1)){
                //不包含当前数字的前一个数字，当前数字是开头
                //以当前数字为开头，记录最长序列的长度
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(num + 1)){
                    //当前数字的下一个数字存在，长度 + 1，直到不包含下一个数字
                    currentStreak += 1;
                    currentNum += 1;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}
