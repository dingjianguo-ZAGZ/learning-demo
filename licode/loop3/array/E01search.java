/**
 * 二分查找
 */
public class E01search {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r){
            int mid = (r - l) / 2 + l;
            if(nums[mid] > target){
                r = mid;
            }else if(nums[mid] < target){
                l = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

}
