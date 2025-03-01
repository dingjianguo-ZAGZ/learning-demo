package greedy;

public class E03maxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int res = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            res = Math.max(res,count);
            if(count < 0){
                //局部和为负数
                count = 0;//相当于重置累计和，从 i+1 开始作为子序列的起始位置
            }
        }
        return res;
    }
}
