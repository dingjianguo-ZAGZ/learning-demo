package binarySearch;

import javax.sound.midi.Soundbank;
import java.util.logging.Level;

public class E064searchRange {
    public static int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    public static int findLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length;//左闭右开
        int res = -1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                //找到不停止
                res = mid;
                //向左找左边界
                r = mid;
            }
        }
        return res;
    }

    public static int findRight(int[] nums, int target) {
        int l = 0;
        int r = nums.length;//左闭右开
        int res = -1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                //找到不停止
                res = mid;
                //向左找左边界
                l = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] ints = searchRange(nums, 8);
        System.out.println(ints[0] +","+ ints[1]);
    }
}
