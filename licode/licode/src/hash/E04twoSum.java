package hash;

import java.util.Arrays;
import java.util.HashMap;


public class E04twoSum {
    public static int[] twoSum(int[] nums, int target) {
        /*HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int dev = target - nums[i];
            if(map.containsKey(dev)){
                //先找到的dev,所以dev的下标小
                return new int[]{map.get(dev),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;*/

        //先对数据进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        int i = 0;
        int j = nums.length-1;
        while (i<j){
            int sum = nums[i] + nums[j];
            if(sum > target){
                j--;
            }else if (sum < target){
                i++;
            }else{
                int[] res = {i, j};
                return res;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int[] ints = twoSum(nums, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}
