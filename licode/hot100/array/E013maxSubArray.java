package array;

/**
 * 最大子数组的和
 */
public class E013maxSubArray {
    public int maxSubArray(int[] nums) {
        //贪心思想，当前子数组的和小于0，则拉低整体和
        if(nums.length == 1){
            return nums[0];
        }
        //区间累计和
        int sum = 0;
        //结果，将结果初始化为最小值
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //先保存结果再清除 sum 值
            res = Math.max(res,sum);
            if(sum <= 0){
                //区间累计和小于0，则不考虑当前区间
                //重置区间起始位置
                sum = 0;
            }
        }
        return res;
    }
}
