package array;

public class E10removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int f = 1;
        int flag = nums[l];
        //2 3 3 3 6 6 8
        //2 3 6 8
        for (; f < nums.length-1; f++) {
            if(nums[f]!=flag){
                l++;
                nums[l] = nums[f];
                flag = nums[f];
            }else{

            }
        }
        return l+1;
    }


}
