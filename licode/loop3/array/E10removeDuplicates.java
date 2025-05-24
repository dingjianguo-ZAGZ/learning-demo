/**
 * 删除数组中重复元素
 */
public class E10removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int s = 0;
        for (int f = 1; f < nums.length; f++) {
            if(nums[f] != nums[s]) {
                s++;
                nums[s] = nums[f];
            }
        }
        return s+1;
    }
}
