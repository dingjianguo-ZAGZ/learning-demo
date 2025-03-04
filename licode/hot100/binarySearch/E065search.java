package binarySearch;

/**
 * 搜索旋转排序数组
 */
public class E065search {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return -1;
        if(len == 1) return nums[0] == target?0:-1;
        int l = 0;
        int r = len;
        int res = -1;//结果值，没找到
        while (l<r){
            int mid = (r-l)/2+l;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > nums[0]){
                //中间值大于起始值，说明左半部分是递增的，所以左半部分完全有序
                if(target >= nums[0] && target < nums[mid]){
                    //判断目标值在左半部分，进行二分查找
                    r = mid;
                }else {
                    //目标值不在左半部分
                    l = mid+1;
                }
            }else {
                //右半部分完全有序
                if(target > nums[mid] && target <= nums[len-1]){
                    l = mid+1;
                }else {
                    r = mid;
                }
            }
        }
        return res;
    }
}
