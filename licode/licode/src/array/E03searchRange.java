package array;

import java.lang.annotation.Target;

public class E03searchRange {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int[] arr = new int[]{-1, -1};
        arr[0] = this.getL(low, high, target,nums);
        arr[1] = this.getR(low, high, target,nums);
        return arr;
    }

    public int getL(int low, int high, int target,int[] nums) {
        int l = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                //标记当前位置
                l = mid;
                high = mid - 1;
            }
        }
        return l;
    }
    public int getR(int low, int high, int target,int[] nums) {
        int r = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                //标记当前位置
                r = mid;
                low = mid + 1;
            }
        }
        return r;
    }
}
