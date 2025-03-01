package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E07threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0]>0){
            return null;
        }
        //先固定一个数
        for (int i = 0; i < nums.length-2; i++) {
            int stack = nums[i];
            //固定的数相同，找到的元组就相同，去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i + 1;
            int r = nums.length-1;
            while (l < r){
                int target = 0 - stack;
                int sum = nums[l] + nums[r];
                if(sum < target){
                    l++;
                }else if(sum > target){
                    r--;
                }else {
                    res.add(Arrays.asList(nums[stack], nums[l], nums[r]));
                    //找到之后，接着找
                    //不能重复
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l--]){
                        l++;
                    }
                    while (l < r && nums[r] == nums[r++]){
                        r--;
                    }
                }
            }
        }
        return res;
    }

}
