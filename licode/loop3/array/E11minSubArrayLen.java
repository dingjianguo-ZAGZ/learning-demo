public class E11minSubArrayLen{
    public int minSubArrayLen(int target, int[] nums) {
        //滑动窗口
        int l = 0;//左指针从0开始
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target){
                //记录候选值
                res = Math.min(res,r - l + 1);
                //移动左指针，缩小窗口
                sum -= nums[l];
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? 0:res;
    }
}
