package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 */
public class E001twoSum {
    public int[] twoSum(int[] nums, int target) {
        //存储出现过的值，从出现过的值中找可以和当前值组合成target的值
        //键 ：出现过的值 值：在数组中的下标
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(target - num)){
                return new int[]{i,map.get(target - num)};
            }else {
                //没有能够组合的值，将当前值加入map
                map.put(num,i);
            }
        }
        return null;
    }
}
