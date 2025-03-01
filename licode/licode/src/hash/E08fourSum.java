package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E08fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        //第一个指针固定a
        for (int i = 0; i < len-3; i++) {
            //如果连续四个相加仍大于target,表示从当前数字开始的四个最小数的和大于target，后面不会再有结果
            if((long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target){
                break;
            }
            //如果第一个值加上最大的三个值仍然小于target,则固定的值没有意义
            if((long)nums[i]+nums[len-1]+nums[len-2]+nums[len-3] < target){
                continue;
            }
            //对 a 去重:两次 a 值相同，则查询到的 结果相同
            if(i > 0 && nums[i] == nums[i-1]) continue;
            //计算三数之和
            //第二个指针固定 b
            for (int j = i+1; j < len-2; j++) {
                //重复a的操作
                //如果连续三个相加仍大于target,表示从当前数字开始的四个最小数的和大于target，后面不会再有结果
                if((long)nums[j]+nums[j+1]+nums[j+2]+nums[i] > target){
                    break;
                }
                //如果第一个值加上最大的两个值仍然小于target,则固定的值没有意义
                if((long)nums[j]+nums[len-1]+nums[len-2]+nums[i] < target){
                    continue;
                }
                //对 b 去重:两次 b 值，则查询到的 c d 值相同
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                //定义两个指针计算两数之和
                int l = j+1;
                int r = len - 1;
                while (l < r){
                    long sum = (long) nums[i] + nums[j] + nums[l] +nums[r];
                    if(sum > target){
                        r--;
                    }else if(sum < target){
                        l++;
                    }else {
                        // 找到四个数之和等于target，加入结果集合
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // 对c数和d数进行去重
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        // 去重后还需要缩小指针范围
                        l++;
                        r--;
                    }
                }

            }
        }
        return res;
    }

}
