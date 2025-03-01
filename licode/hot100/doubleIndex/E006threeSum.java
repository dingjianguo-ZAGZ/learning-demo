package doubleIndex;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和 = 0
 * 双指针算法
 */
public class E006threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //定义结果集
        List<List<Integer>> res = new ArrayList<>();
        //按照升序排序
        Arrays.sort(nums);
        if(nums[0] > 0) return res;
        /**
         * 使用 i 定义一个指针 a，使用 left指针 固定一个值 b，使用 right指针 固定一个值 c
         * i 的范围是 [0,nums.length - 3] 后面空两个位置 left ,right
         */
        for (int i = 0; i < nums.length-2; i++) {
            //对 a 去重，三元组不能重复，三元组中的元素可以重复
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //计算逻辑
            int left = i + 1;
            int right = nums.length - 1;
            // 1.固定 a 找到其他两个值
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else {
                    //2.找到三数之和等于 0，加入结果集
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //3.同一个 a，继续移动 b , c 寻找，注意对 b , c 去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

}
