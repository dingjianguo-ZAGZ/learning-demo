package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 k 的子数组
 */
public class E010subarraySum {
    public int subarraySum(int[] nums, int k) {
        //定义结果集
        int res = 0;
        //map 数组优化存储 键：前 i 个数字的和  值：这个和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        //前 i 个数字的和
        int pre = 0;
        //将下标为 1 之前的和放入
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if(map.containsKey(pre - k)){
                res += map.get(pre - k);
            }
            //更新map中存储的个数
            map.put(pre, map.getOrDefault(pre,0)+1);
        }
        return res;
    }
}
