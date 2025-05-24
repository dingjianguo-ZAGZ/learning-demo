public class E03searchRange {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findLeft(nums,target),findRight(nums,target)};
    }
    public int findLeft(int[] nums,int target){
        int l = 0;
        int r = nums.length;
        int res = -1;
        while(l < r){
            int mid = (r - l) / 2 + l;
            if(nums[mid] == target){
                //找到不停止，寻找左边界
                res = mid;
                r = mid;
            }else if(nums[mid] > target){
                r = mid;
            }else if(nums[mid] < target){
                l = mid+1;
            }
        }
        return res;
    }
    public int findRight(int[] nums,int target){
        int l = 0;
        int r = nums.length;
        int res = -1;
        while(l < r){
            int mid = (r - l) / 2 + l;
            if(nums[mid] == target){
                //找到不停止，寻找右边界
                res = mid;
                l = mid+1;
            }else if(nums[mid] > target){
                r = mid;
            }else if(nums[mid] < target){
                l = mid+1;
            }
        }
        return res;
    }
}
