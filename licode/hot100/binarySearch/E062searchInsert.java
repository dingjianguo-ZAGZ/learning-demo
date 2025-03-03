package binarySearch;

public class E062searchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l<r){
            int mid = (r - l) / 2 + l;
            int num = nums[mid];
            if(num > target){
                r = mid;
            }else if(num < target){
                l = mid+1;
            }else {
                return mid;
            }
        }
        return l;
    }
}
