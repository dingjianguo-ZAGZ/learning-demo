package heart;

/**
 * 条约格子
 */
public class E077boolean {
    public boolean canJump(int[] nums) {
        //局部最优：可以跳的最大范围 找出下一步可以跳的最大范围
        if (nums.length == 1) return true;
        int range = nums[0];
        int i = 1;
        while (i <= range) {
            range = Math.max(range, i + nums[i]);
            if (range >= nums.length - 1){
                return true;
            }
            ++i;
        }
        return false;
    }
}
