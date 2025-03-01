package array;

public class E06removeElement {
    public int removeElement(int[] nums, int val) {
        /*//[2 9 6 5 4 9 7]
        //
        //找到第一个等于val的和第一个不等于val的
        int temp = nums.length-1;
        for (int l = 0; l < nums.length; l++) {
            if(nums[l]==val){
                for (int r = temp; r > l; r--) {
                    if(nums[r]!=val){
                        temp = r-1;
                        int num = nums[l];
                        nums[l] = nums[r];
                        nums[r] = num;
                    }
                }
            }
        }
        return nums.length-temp;*/

        //[2 6 5 4 7 9 7]

        int l = 0;
        int f = 0;
        for (; f < nums.length; f++) {
            if(nums[f]!=val){
                nums[l] = nums[f];
                l++;
            }
        }
        return l;
    }
}
