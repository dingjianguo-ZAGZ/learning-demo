package doubleIndex;

/**
 * 移动 0
 */
public class E004moveZeroes {
    public void moveZeroes(int[] nums) {
        //双指针思路：快指针扫描，慢指针构建
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if(nums[fast] != 0 && nums[slow] == 0){
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
            }else if(nums[slow] != 0){
                slow++;
            }
        }
    }
}
