package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E32twoSum {
    Map<Integer, Integer> res = new HashMap<>();
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (res.containsKey(target - num)) {
                return new int[]{i, res.get(target - num)};
            }else {
                res.put(num,i);
            }

        }
        return null;
    }
}
