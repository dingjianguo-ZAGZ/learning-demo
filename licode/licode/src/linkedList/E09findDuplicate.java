package linkedList;

import java.util.HashMap;
import java.util.Map;

public class E09findDuplicate {
    public int findDuplicate(int[] nums) {
        //哈希表
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            boolean containsKey = map.containsKey(num);
            if (containsKey) {
                return num; // 如果一个值已经出现过，则直接返回这个数
            } else {
                map.put(num, 1); // 如果没有出现过，则放入map集合中
            }
        }
        return -1;
    }
    /*public int findDuplicate(int[] nums) {
        //哈希表
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //判断key中是否存在值，如果存在，则重复。
            if(map.get(nums[i]) != null){
                return nums[i];
            }
            map.put(nums[i],1);
        }
        return -1;
    }*/


}
