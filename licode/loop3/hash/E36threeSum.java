package hash;

import java.util.*;

public class E36threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0] > 0) return res;

        for (int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if( sum> 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else {
                    res.add(new ArrayList<>(Arrays.asList(nums[left],nums[right],nums[i])));
                    //去重
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    //找到答案，双指针同时收缩
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
