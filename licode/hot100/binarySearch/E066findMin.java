package binarySearch;

/**
 * 153.寻找旋转排序数组中的最小值
 */
public class E066findMin {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[r] > nums[mid]) {
                //中间值小于最后的值，说明中间值右半部分完全有序（递增），忽略后半部分
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        //此时 l=r，就是最小值
        return nums[l];
    }
}
