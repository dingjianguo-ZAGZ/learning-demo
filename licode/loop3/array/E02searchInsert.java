public class E02searchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        int mid = 0;
        while (l < r) {
            mid = (r - l) / 2 + l;
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        if (nums[mid] > target && mid == 0) {
            return 0;
        }
        return nums[mid] > target ? mid : mid + 1;
    }
}
